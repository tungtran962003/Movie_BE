package com.example.movie_web_be.request;

import com.example.movie_web_be.entity.MovieType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieTypeRequest {

    private String name;

    public MovieType create(MovieType movieType) {
        movieType.setName(this.name);
        movieType.setIsActive(true);
        return movieType;
    }
}
