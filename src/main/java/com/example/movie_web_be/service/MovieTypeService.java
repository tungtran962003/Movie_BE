package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.MovieType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieTypeService {

    List<MovieType> getAll();

    Page<MovieType> getPage(Integer page, Integer pageSize);

    Boolean create(String name);

    Boolean update(Integer idUpdate, String name);

    Boolean delete(Integer idDelete);
}
