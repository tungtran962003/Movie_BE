package com.example.movie_web_be.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninRequest {

    private String email;

    private String password;
}
