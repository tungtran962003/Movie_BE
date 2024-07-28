package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Favourite;
import com.example.movie_web_be.request.CinemaRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FavouriteService {

    List<Favourite> getAll();

    Page<Favourite> getPage(Integer page, Integer pageSize);

    MessageResponse create(Integer movieId);

    MessageResponse delete(Integer idDelete);
}
