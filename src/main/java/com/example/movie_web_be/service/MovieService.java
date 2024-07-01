package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.request.MovieRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface MovieService {

    Page<Movie> getPage(int size);

    String create(MovieRequest movieRequest, MultipartFile file);
}
