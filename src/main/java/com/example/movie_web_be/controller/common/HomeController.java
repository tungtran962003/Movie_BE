package com.example.movie_web_be.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {


    @GetMapping()
    public ResponseEntity<?> getMovieIsShowing() {
        return null;
    }
}
