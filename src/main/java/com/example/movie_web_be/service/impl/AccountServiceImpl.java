package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Account;
import com.example.movie_web_be.repository.AccountRepository;
import com.example.movie_web_be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Page<Account> getPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return accountRepository.findAllByIsActiveOrderByUpdateDateDesc(pageable, true);
    }
}
