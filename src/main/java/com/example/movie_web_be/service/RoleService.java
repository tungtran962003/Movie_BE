package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByRoleName(String roleName);
}
