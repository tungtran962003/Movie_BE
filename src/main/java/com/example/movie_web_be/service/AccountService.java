package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Account;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Page<Account> getPage(Integer page, Integer pageSize);

    MessageResponse create(String name, String email, String password, Boolean gender, String birthDay, String phoneNumber, Integer rankCustomerId, Integer roleId, MultipartFile file) throws ParseException;

    MessageResponse update(Integer idUpdate, String name, String email, String password, Boolean gender, String birthDay, String phoneNumber, Integer rankCustomerId, Integer roleId, MultipartFile file) throws ParseException;

    MessageResponse delete(Integer idDelete);
}
