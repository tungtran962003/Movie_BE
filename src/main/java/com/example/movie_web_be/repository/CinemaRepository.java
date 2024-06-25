package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    Page<Cinema> findAllByIsActiveOrderByUpdateDateDesc(Pageable pageable, Boolean isActive);
}
