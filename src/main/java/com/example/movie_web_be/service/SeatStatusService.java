package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.MovieType;
import com.example.movie_web_be.entity.SeatStatus;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SeatStatusService {

    List<SeatStatus> getAll();

    Page<SeatStatus> getPage(Integer page, Integer pageSize);

    MessageResponse create(String name);

    MessageResponse update(Integer idUpdate, String name);

    MessageResponse delete(Integer idDelete);
}
