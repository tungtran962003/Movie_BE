package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.repository.MovieRepository;
import com.example.movie_web_be.request.MovieRequest;
import com.example.movie_web_be.service.MovieService;
import com.example.movie_web_be.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {

    private final String uploadDir = "./src/main/resources/static/assets/movie/";

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<Movie> getPage(int size) {
        Pageable pageable = PageRequest.of(size, 10);
        return movieRepository.getMovieIsShowing(pageable);
    }

    @Override
    public String create(MovieRequest movieRequest, MultipartFile file) {
        Movie movie = movieRequest.addMovie(new Movie());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileMovie = "movie" + new Date().getTime();
        String moviePath = FileUtil.copyFile(file, fileName, uploadDir);
        movieRepository.save(movie);
        return "ok";
    }
}
