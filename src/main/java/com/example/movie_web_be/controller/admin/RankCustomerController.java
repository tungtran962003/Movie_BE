package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.RankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rankCustomer")
@CrossOrigin(origins = "${my.string.property}")
public class RankCustomerController {

    @Autowired
    private RankCustomerService rankCustomerService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(rankCustomerService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(rankCustomerService.getPage(page, pageSize));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam String name,
                                    @RequestParam Integer point) {
        return ResponseEntity.ok(rankCustomerService.create(name, point));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestParam String name,
                                    @RequestParam Integer point) {
        return ResponseEntity.ok(rankCustomerService.update(idUpdate, name, point));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(rankCustomerService.delete(idDelete));
    }
}
