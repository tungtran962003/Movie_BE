package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.SeatStatusService;
import com.example.movie_web_be.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin(origins = "${my.string.property}")
@RequestMapping("/api/seatType")
public class SeatTypeController {

    @Autowired
    private SeatTypeService seatTypeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(seatTypeService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(seatTypeService.getPage(page, pageSize));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestParam String name, @RequestParam BigDecimal price) {
        return ResponseEntity.ok(seatTypeService.create(name, price));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Integer idUpdate, @RequestParam String name, @RequestParam BigDecimal price) {
        return ResponseEntity.ok(seatTypeService.update(idUpdate, name, price));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(seatTypeService.delete(idDelete));
    }
}
