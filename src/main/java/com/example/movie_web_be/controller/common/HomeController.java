package com.example.movie_web_be.controller.common;

import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "${my.string.property}")
public class HomeController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity<?> home() {
        List<Movie> listMovieIsShowing = movieService.getListMovieIsShowing();
        List<Movie> listUpComingMovie = movieService.getListUpComingMovie();
        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("listMovieIsShowing", listMovieIsShowing);
        hmap.put("listUpComingMovie", listUpComingMovie);
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
}
