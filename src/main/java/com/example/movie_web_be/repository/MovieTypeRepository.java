package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.MovieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieTypeRepository extends JpaRepository<MovieType, Integer> {

    List<MovieType> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<MovieType> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    MovieType findByNameAndIsActive(String name, Boolean isActive);

    MovieType findByIdAndIsActive(Integer id, Boolean isActive);
}
