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

    public Movie addMovie(Movie movie) {
        movie.setName(this.name);
        movie.setTime(this.time);
        movie.setPremiereDate(this.premiereDate);
        movie.setDescription(this.description);
        movie.setDirector(this.director);
        movie.setLanguage(this.language);
        movie.setPerformer(this.performer);
        movie.setIsActive(true);
        movie.setMovieType(MovieType.builder().id(this.movieTypeId).build());
        return movie;
    }
}
