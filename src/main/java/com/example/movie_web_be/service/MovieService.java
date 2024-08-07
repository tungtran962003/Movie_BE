package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

public interface MovieService {

    Page<Movie> getPageMovie(Integer size, Integer pageSize);

    Page<Movie> getPageMovieIsShowing(Integer size, Integer pageSize);

    Page<Movie> getPageUpComingMovie(Integer size, Integer pageSize);

    List<Movie> getListMovieIsShowing();

    List<Movie> getListUpComingMovie();

    MessageResponse create(String name, Integer time, String premiereDate, String description, String director,
                           String language, String performer, Integer movieTypeId, String trailer, MultipartFile file) throws ParseException;

    MessageResponse update(Integer idUpdate, String name, Integer time, String premiereDate, String description, String director,
                           String language, String performer, Integer movieTypeId, String trailer, MultipartFile file) throws ParseException;

    MessageResponse delete(Integer idDelete);

    Page<Movie> search(Integer page, Integer pageSize, String name, String startDate, String endDate, String director, String language, String performer, Integer movieTypeId) throws ParseException;
}
