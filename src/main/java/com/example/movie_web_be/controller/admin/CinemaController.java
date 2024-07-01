package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0", value = "page") int page) {
        return ResponseEntity.ok(cinemaService.getPage(page));
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> add() {
//
//    }
}
