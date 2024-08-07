package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

@CrossOrigin(origins = "${my.string.property}")
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(movieService.getPageMovie(page, pageSize));
    }

    @GetMapping("/isShowing")
    public ResponseEntity<?> getPageMovieIsShowing(@RequestParam Integer page,
                                                   @RequestParam Integer pageSize) {
        return ResponseEntity.ok(movieService.getPageMovieIsShowing(page, pageSize));
    }

    @GetMapping("/upComing")
    public ResponseEntity<?> getPageUpComingMovie(@RequestParam Integer page,
                                                   @RequestParam Integer pageSize) {
        return ResponseEntity.ok(movieService.getPageUpComingMovie(page, pageSize));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestParam String name,
                                    @RequestParam Integer time,
                                    @RequestParam String premiereDate,
                                    @RequestParam String description,
                                    @RequestParam String director,
                                    @RequestParam String language,
                                    @RequestParam String performer,
                                    @RequestParam Integer movieTypeId,
                                    @RequestParam String trailer,
                                    @RequestParam MultipartFile file) throws ParseException {
        return ResponseEntity.ok(movieService.create(name, time, premiereDate, description, director,
                language, performer, movieTypeId, trailer, file));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestParam Integer idUpdate,
                                    @RequestParam String name,
                                    @RequestParam Integer time,
                                    @RequestParam String premiereDate,
                                    @RequestParam String description,
                                    @RequestParam String director,
                                    @RequestParam String language,
                                    @RequestParam String performer,
                                    @RequestParam String trailer,
                                    @RequestParam Integer movieTypeId,
                                    @RequestParam(required = false) MultipartFile file) throws ParseException {
        return ResponseEntity.ok(movieService.update(idUpdate, name, time, premiereDate, description, director,
                language, performer, movieTypeId, trailer, file));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(movieService.delete(idDelete));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Integer page,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String startDate,
                                    @RequestParam(required = false) String endDate,
                                    @RequestParam(required = false) String director,
                                    @RequestParam(required = false) String language,
                                    @RequestParam(required = false) String performer,
                                    @RequestParam(required = false) Integer movieTypeId) throws ParseException {
        return ResponseEntity.ok(movieService.search(page, pageSize, name, startDate, endDate, director, language, performer, movieTypeId));
    }

}
