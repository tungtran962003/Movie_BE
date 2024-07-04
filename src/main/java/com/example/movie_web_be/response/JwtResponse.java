package com.example.movie_web_be.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {

    private String jwt;

    private String type = "Bearer";

    private String name;

    private String email;

    private List<String> roles;

    private String avatar;

    public JwtResponse(String jwt, String name, String email, List<String> roles, String avatar) {
        this.jwt = jwt;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.avatar = avatar;
    }
}
