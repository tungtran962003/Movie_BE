package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Role;
import com.example.movie_web_be.repository.RoleRepository;
import com.example.movie_web_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findByRoleName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
