package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Room> findAllByIsActiveAndCinema_IdOrderByIdDesc(Pageable pageable, Integer cinemaId, Boolean isActive);

    Room findByNameAndIsActive(String name, Boolean isActive);

    Room findByIdAndIsActive(Integer id, Boolean isActive);
}
