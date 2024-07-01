package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.request.MovieRequest;
import com.example.movie_web_be.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "${my.string.property}")
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(movieService.getPage(page).getContent());
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody MovieRequest movieRequest,
                                 @RequestParam MultipartFile file) {
        return ResponseEntity.ok(movieService.create(movieRequest, file));
    }
}
