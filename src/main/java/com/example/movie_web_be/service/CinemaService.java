package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Cinema;
import org.springframework.data.domain.Page;

public interface CinemaService {

    Page<Cinema> getPage(int page);
}
