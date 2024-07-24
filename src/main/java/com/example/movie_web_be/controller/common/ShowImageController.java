package com.example.movie_web_be.controller.common;

import com.example.movie_web_be.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "${my.string.property}")
public class ShowImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{movieId}")
    public ResponseEntity<byte[]> getImageMovie(@PathVariable Integer movieId) {
        byte[] imageMovie = imageService.getImageMovie(movieId);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageMovie);
    }
}
