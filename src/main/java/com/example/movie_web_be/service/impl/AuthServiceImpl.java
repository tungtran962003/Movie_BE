package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Account;
import com.example.movie_web_be.entity.RankCustomer;
import com.example.movie_web_be.entity.Role;
import com.example.movie_web_be.repository.AccountRepository;
import com.example.movie_web_be.repository.RoleRepository;
import com.example.movie_web_be.request.SigninRequest;
import com.example.movie_web_be.request.SignupRequest;
import com.example.movie_web_be.response.JwtResponse;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.security.jwt.JwtUtil;
import com.example.movie_web_be.security.service.UserDetailsImpl;
import com.example.movie_web_be.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public MessageResponse register(SignupRequest signupRequest) throws ParseException {
        if (accountRepository.existsAccountByEmail(signupRequest.getEmail())) {
            return new MessageResponse("Email already exists", 1);
        }
        Account account = new Account();
        Role role = new Role();
        if (signupRequest.getRoleName() == null || "".equals(signupRequest.getRoleName())) {
            role = roleRepository.findByName("User").orElse(null);
            if (role == null) {
                return new MessageResponse("Role is not found", 1);
            }
        } else {
            switch (signupRequest.getRoleName()) {
                case "Admin":
                    role = roleRepository.findByName("Admin").orElse(null);
                    return role == null ? new MessageResponse("Role is not found", 1) : null;
                case "Staff":
                    return role == null ? new MessageResponse("Role is not found", 1) : null;
                default:
                    return role == null ? new MessageResponse("Role is not found", 1) : null;
            }
        }
        account.setEmail(signupRequest.getEmail());
        account.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        account.setIsActive(true);
        account.setBirthDay(sdf.parse(signupRequest.getBirthDay()));
        account.setName(signupRequest.getName());
        account.setCreateDate(new Date());
        account.setUpdateDate(new Date());
        account.setRole(role);
        account.setPhoneNumber(signupRequest.getPhoneNumber());
        account.setRankCustomer(RankCustomer.builder().id(1).build());
        accountRepository.save(account);
        return new MessageResponse("Account registration successful", 0);
    }

    @Override
    public JwtResponse login(SigninRequest signinRequest) throws InterruptedException {
        if (signinRequest.getDelay() != null) {
            Thread.sleep(signinRequest.getDelay());
        }
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword())
            );
        } catch (Exception e) {
            return null;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return new JwtResponse(jwt, userDetails.getName(), userDetails.getEmail(), roles, userDetails.getAvatar(), 0);
    }

    @Override
    public MessageResponse logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new MessageResponse("Logout success", 0);
    }
}
