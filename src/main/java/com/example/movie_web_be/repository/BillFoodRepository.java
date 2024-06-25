package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.BillFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillFoodRepository extends JpaRepository<BillFood, Integer> {
}
