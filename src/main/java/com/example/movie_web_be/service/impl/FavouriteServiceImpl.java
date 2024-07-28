package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Favourite;
import com.example.movie_web_be.repository.FavouriteRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public List<Favourite> getAll() {
        return null;
    }

    @Override
    public Page<Favourite> getPage(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public MessageResponse create(Integer movieId) {
        return null;
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        return null;
    }
}
