package com.example.movie_web_be.controller.common;

import com.example.movie_web_be.request.SigninRequest;
import com.example.movie_web_be.request.SignupRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin(origins = "${my.string.property}")
@RestController
@RequestMapping()
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest) throws ParseException {
        return ResponseEntity.ok(authService.register(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SigninRequest signinRequest) throws InterruptedException {
        return ResponseEntity.ok(authService.login(signinRequest) == null ? new MessageResponse("Email or password is correct", 1) : authService.login(signinRequest));
    }

    @GetMapping("/logoutAccount")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok((authService.logout(token)));
    }

    @GetMapping("/principal")
    public ResponseEntity<?> getAccountPrincipal(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(authService.getPrincipal(token));
    }
}
