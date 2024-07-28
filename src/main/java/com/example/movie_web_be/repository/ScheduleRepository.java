package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Schedule> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Schedule findByIdAndIsActive(Integer id, Boolean isActive);
}
