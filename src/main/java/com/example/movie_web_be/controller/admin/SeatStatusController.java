package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${my.string.property}")
@RequestMapping("/api/seatStatus")
public class SeatStatusController {

    @Autowired
    private SeatStatusService seatStatusService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(seatStatusService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(seatStatusService.getPage(page, pageSize));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestParam String name) {
        return ResponseEntity.ok(seatStatusService.create(name));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Integer idUpdate, @RequestParam String name) {
        return ResponseEntity.ok(seatStatusService.update(idUpdate, name));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(seatStatusService.delete(idDelete));
    }
}
