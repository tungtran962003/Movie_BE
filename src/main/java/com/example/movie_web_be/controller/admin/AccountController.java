package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "${my.string.property}")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(accountService.getPage(page, pageSize));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam Boolean gender,
                                    @RequestParam String birthDay,
                                    @RequestParam String phoneNumber,
                                    @RequestParam Integer rankCustomerId,
                                    @RequestParam Integer roleId,
                                    @RequestParam MultipartFile file) throws ParseException {
        return ResponseEntity.ok(accountService.create(name, email, password, gender, birthDay, phoneNumber, rankCustomerId, roleId, file));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate,
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam Boolean gender,
                                    @RequestParam String birthDay,
                                    @RequestParam String phoneNumber,
                                    @RequestParam Integer rankCustomerId,
                                    @RequestParam Integer roleId,
                                    @RequestParam(required = false) MultipartFile file) throws ParseException {
        return ResponseEntity.ok(accountService.update(idUpdate, name, email, password, gender, birthDay, phoneNumber, rankCustomerId, roleId, file));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(accountService.delete(idDelete));
    }

}
