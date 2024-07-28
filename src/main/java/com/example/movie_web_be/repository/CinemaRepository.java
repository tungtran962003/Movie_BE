package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    List<Cinema> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Cinema> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Cinema findByNameAndIsActive(String name, Boolean isActive);

    Cinema findByIdAndIsActive(Integer id, Boolean isActive);

    @Query(value = "SELECT r FROM Room r " +
            "INNER JOIN Cinema c ON c.id = r.cinema.id " +
            "WHERE c.id =:cinemaId")
    List<Room> getListRoomByCinemaId(Integer cinemaId);
}
