package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Account;
import com.example.movie_web_be.entity.RankCustomer;
import com.example.movie_web_be.entity.Role;
import com.example.movie_web_be.repository.AccountRepository;
import com.example.movie_web_be.repository.RoleRepository;
import com.example.movie_web_be.request.SigninRequest;
import com.example.movie_web_be.request.SignupRequest;
import com.example.movie_web_be.response.JwtResponse;
import com.example.movie_web_be.security.jwt.JwtUtil;
import com.example.movie_web_be.security.service.UserDetailsImpl;
import com.example.movie_web_be.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Override
    public String register(SignupRequest signupRequest) {
        if (accountRepository.existsAccountByEmail(signupRequest.getEmail())) {
            return "Email already exists";
        }
        Account account = new Account();
        Role role = new Role();
        if (signupRequest.getRoleName() == null || "".equals(signupRequest.getRoleName())) {
            role = roleRepository.findByName("User").orElseThrow(() -> new RuntimeException("Role is not found"));
        } else {
            switch (signupRequest.getRoleName()) {
                case "Admin":
                    role = roleRepository.findByName("Admin").orElseThrow(() -> new RuntimeException("Role id not found"));
                    break;
                case "Staff":
                    role = roleRepository.findByName("Staff").orElseThrow(() -> new RuntimeException("Role id not found"));
                    break;
                default:
                    return "Role is not found";
            }
        }
        account.setEmail(signupRequest.getEmail());
        account.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        account.setIsActive(true);
        account.setBirthDay(null);
        account.setName(signupRequest.getName());
        account.setCreateDate(new Date());
        account.setUpdateDate(new Date());
        account.setRole(role);
        account.setPhoneNumber(null);
        account.setRankCustomer(RankCustomer.builder().id(1).build());
        accountRepository.save(account);
        return "Account registration successful";
    }

    @Override
    public JwtResponse login(SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());
        return new JwtResponse(jwt, userDetails.getName(), userDetails.getEmail(), roles, userDetails.getAvatar());
    }
}
