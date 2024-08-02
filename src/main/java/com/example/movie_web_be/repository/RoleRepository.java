package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);

    List<Role> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Role> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Role findByNameAndIsActive(String name, Boolean isActive);

    Role findByIdAndIsActive(Integer id, Boolean isActive);
}
