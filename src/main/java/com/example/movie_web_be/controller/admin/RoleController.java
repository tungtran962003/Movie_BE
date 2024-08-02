package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "${my.string.property}")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(roleService.getPage(page, pageSize));
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody CinemaRequest cinemaRequest) {
//        return ResponseEntity.ok(roleService.create(cinemaRequest));
//    }

//    @PutMapping("/update/{idUpdate}")
//    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody CinemaRequest cinemaRequest) {
//        return ResponseEntity.ok(cinemaService.update(idUpdate, cinemaRequest));
//    }
//
//    @DeleteMapping("/delete/{idDelete}")
//    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
//        return ResponseEntity.ok(cinemaService.delete(idDelete));
//    }
}
