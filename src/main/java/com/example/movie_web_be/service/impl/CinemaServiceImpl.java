package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.repository.CinemaRepository;
import com.example.movie_web_be.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Page<Cinema> getPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return cinemaRepository.findAllByIsActiveOrderByUpdateDateDesc(pageable, true);
    }

//    public Cinema add() {
//
//    }
}
