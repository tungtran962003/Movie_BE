package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favourite")
@CrossOrigin(origins = "${my.string.property}")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(favouriteService.getAll());
    }

}
