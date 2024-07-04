package com.example.movie_web_be.service;

import com.example.movie_web_be.request.SigninRequest;
import com.example.movie_web_be.request.SignupRequest;
import com.example.movie_web_be.response.JwtResponse;

public interface AuthService {

    String register(SignupRequest signupRequest);

    JwtResponse login(SigninRequest signinRequest);
}
