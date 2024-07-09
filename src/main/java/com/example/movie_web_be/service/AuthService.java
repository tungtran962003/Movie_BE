package com.example.movie_web_be.service;

import com.example.movie_web_be.request.SigninRequest;
import com.example.movie_web_be.request.SignupRequest;
import com.example.movie_web_be.response.JwtResponse;
import com.example.movie_web_be.response.MessageResponse;

import java.text.ParseException;

public interface AuthService {

    MessageResponse register(SignupRequest signupRequest) throws ParseException;

    JwtResponse login(SigninRequest signinRequest) throws InterruptedException;

    MessageResponse logout();
}
