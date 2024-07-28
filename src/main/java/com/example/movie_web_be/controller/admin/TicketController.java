package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.request.TicketRequest;
import com.example.movie_web_be.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "${my.string.property}")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(ticketService.getPage(page, pageSize));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TicketRequest ticketRequest) {
        return ResponseEntity.ok(ticketService.create(ticketRequest));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody TicketRequest ticketRequest) {
        return ResponseEntity.ok(ticketService.update(idUpdate, ticketRequest));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(ticketService.delete(idDelete));
    }
}
