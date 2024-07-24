package com.example.movie_web_be.request;

import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.entity.MovieType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieRequest {

    private String name;

    private Integer time;

    private Date premiereDate;

    private String description;

    private String director;

    private String language;

    private String performer;

    private Integer movieTypeId;
}
