package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.RankCustomer;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RankCustomerService {

    List<RankCustomer> getAll();

    Page<RankCustomer> getPage(Integer page, Integer pageSize);

    MessageResponse create(String name, Integer point);

    MessageResponse update(Integer idUpdate, String name, Integer point);

    MessageResponse delete(Integer idDelete);
}
