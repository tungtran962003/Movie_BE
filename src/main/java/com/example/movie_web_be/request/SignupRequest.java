package com.example.movie_web_be.request;

import com.example.movie_web_be.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String name;

    private String email;

    private String password;

    private String phoneNumber;

    private String roleName;

}
