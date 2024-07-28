package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.request.RoomRequest;
import com.example.movie_web_be.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "${my.string.property}")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize,
                                     @RequestParam Integer cinemaId) {
        return ResponseEntity.ok(roomService.getPage(page, pageSize, cinemaId));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RoomRequest roomRequest) {
        return ResponseEntity.ok(roomService.create(roomRequest));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody RoomRequest roomRequest) {
        return ResponseEntity.ok(roomService.update(idUpdate, roomRequest));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(roomService.delete(idDelete));
    }
}
