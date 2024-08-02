package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.RankCustomer;
import com.example.movie_web_be.entity.Role;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> findByRoleName(String roleName);

    List<Role> getAll();

    Page<Role> getPage(Integer page, Integer pageSize);

}
