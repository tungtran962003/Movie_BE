package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.SeatStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatus, Integer> {

    List<SeatStatus> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<SeatStatus> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    SeatStatus findByNameAndIsActive(String name, Boolean isActive);

    SeatStatus findByIdAndIsActive(Integer id, Boolean isActive);
}
