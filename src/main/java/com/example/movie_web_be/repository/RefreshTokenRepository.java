package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    RefreshToken findTopByAccount_IdOrderByIdDesc(Integer accountId);
}
