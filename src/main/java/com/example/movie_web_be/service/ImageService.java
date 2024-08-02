package com.example.movie_web_be.service;

public interface ImageService {

    byte[] getImageMovie(Integer movieId);

    byte[] getAvatarAccount(Integer accountId);
}
