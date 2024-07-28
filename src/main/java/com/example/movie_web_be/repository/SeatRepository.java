package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.entity.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Seat> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Seat findByCodeAndIsActive(String code, Boolean isActive);

    Seat findByIdAndIsActive(Integer id, Boolean isActive);
}
