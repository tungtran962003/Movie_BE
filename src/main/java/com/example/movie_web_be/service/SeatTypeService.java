package com.example.movie_web_be.service;


import com.example.movie_web_be.entity.SeatStatus;
import com.example.movie_web_be.entity.SeatType;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface SeatTypeService {

    List<SeatType> getAll();

    Page<SeatType> getPage(Integer page, Integer pageSize);

    MessageResponse create(String name, BigDecimal price);

    MessageResponse update(Integer idUpdate, String name, BigDecimal price);

    MessageResponse delete(Integer idDelete);

}
