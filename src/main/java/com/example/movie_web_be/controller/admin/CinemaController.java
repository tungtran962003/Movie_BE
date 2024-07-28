package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.request.CinemaRequest;
import com.example.movie_web_be.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cinema")
@CrossOrigin(origins = "${my.string.property}")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(cinemaService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(cinemaService.getPage(page, pageSize));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CinemaRequest cinemaRequest) {
        return ResponseEntity.ok(cinemaService.create(cinemaRequest));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody CinemaRequest cinemaRequest) {
        return ResponseEntity.ok(cinemaService.update(idUpdate, cinemaRequest));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(cinemaService.delete(idDelete));
    }

    @GetMapping("/{cinemaId}/room")
    public ResponseEntity<?> getListRoomByCinemaId(@PathVariable Integer cinemaId, @RequestParam Integer page,
                                                   @RequestParam Integer pageSize) {
        Page<Room> pageRoom = cinemaService.getPageRoomByCinemaId(cinemaId, page, pageSize);
        return ResponseEntity.ok(pageRoom);
    }
}
