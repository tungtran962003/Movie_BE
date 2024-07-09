package com.example.movie_web_be.request;

import com.example.movie_web_be.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String name;

    private Boolean gender;

    private String email;

    private String password;

    private String phoneNumber;

    private String birthDay;

    private String roleName;

}
