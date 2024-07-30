package com.example.movie_web_be.repository;

import com.example.movie_web_be.dto.admin.RoomDto;
import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    @Query(value = "SELECT r.id as id, " +
            "r.capacity as capacity, " +
            "r.name as name, " +
            "r.cinema.id as cinemaId, " +
            "r.cinema.name as cinemaName " +
            "FROM Room r " +
            "INNER JOIN Cinema c ON r.cinema.id = c.id " +
            "WHERE c.id =:cinemaId AND r.isActive = true AND c.isActive = true")
    Page<RoomDto> getListRoomByCinemaIdPaginate(Pageable pageable, Integer cinemaId);

    Room findByNameAndIsActive(String name, Boolean isActive);

    Room findByIdAndIsActive(Integer id, Boolean isActive);
}
