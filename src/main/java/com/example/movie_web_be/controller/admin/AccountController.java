package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0", value = "page") int page) {
        return ResponseEntity.ok(accountService.getPage(page));
    }
}
