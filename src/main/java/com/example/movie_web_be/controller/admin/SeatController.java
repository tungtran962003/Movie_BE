package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.request.SeatRequest;
import com.example.movie_web_be.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seat")
@CrossOrigin(origins = "${my.string.property}")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(seatService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(seatService.getPage(page, pageSize));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SeatRequest seatRequest) {
        return ResponseEntity.ok(seatService.create(seatRequest));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody SeatRequest seatRequest) {
        return ResponseEntity.ok(seatService.update(idUpdate, seatRequest));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(seatService.delete(idDelete));
    }
}
