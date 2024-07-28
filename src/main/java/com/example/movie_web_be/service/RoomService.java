package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.request.CinemaRequest;
import com.example.movie_web_be.request.RoomRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoomService {

    List<Room> getAll();

    Page<Room> getPage(Integer page, Integer pageSize, Integer cinemaId);

    MessageResponse create(RoomRequest roomRequest);

    MessageResponse update(Integer idUpdate, RoomRequest roomRequest);

    MessageResponse delete(Integer idDelete);
}
