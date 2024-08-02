package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Role;
import com.example.movie_web_be.repository.RoleRepository;
import com.example.movie_web_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findByRoleName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Role> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return roleRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }
}
