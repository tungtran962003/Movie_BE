package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${my.string.property}")
@RequestMapping("/api/movieType")
public class MovieTypeController {

    @Autowired
    private MovieTypeService movieTypeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(movieTypeService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(movieTypeService.getPage(page, pageSize));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestParam String name) {
        return ResponseEntity.ok(movieTypeService.create(name));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Integer idUpdate, @RequestParam String name) {
        return ResponseEntity.ok(movieTypeService.update(idUpdate, name));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(movieTypeService.delete(idDelete));
    }
}
