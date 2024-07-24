package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.SeatStatus;
import com.example.movie_web_be.entity.SeatType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {

    List<SeatType> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<SeatType> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    SeatType findByNameAndIsActive(String name, Boolean isActive);

    SeatType findByIdAndIsActive(Integer id, Boolean isActive);
}
