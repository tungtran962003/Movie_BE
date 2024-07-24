package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.request.CinemaRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface CinemaService {

    List<Cinema> getAll();

    Page<Cinema> getPage(Integer page, Integer pageSize);

    MessageResponse create(CinemaRequest cinemaRequest);

    MessageResponse update(Integer idUpdate, CinemaRequest cinemaRequest);

    MessageResponse delete(Integer idDelete);
}
