package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Account;
import org.springframework.data.domain.Page;

public interface AccountService {

    Page<Account> getPage(int page);

    Boolean checkExistsEmail(String email);
}
