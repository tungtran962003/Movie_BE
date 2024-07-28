package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Seat;
import com.example.movie_web_be.request.SeatRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SeatService {

    List<Seat> getAll();

    Page<Seat> getPage(Integer page, Integer pageSize);

    MessageResponse create(SeatRequest seatRequest);

    MessageResponse update(Integer idUpdate, SeatRequest seatRequest);

    MessageResponse delete(Integer idDelete);
}
