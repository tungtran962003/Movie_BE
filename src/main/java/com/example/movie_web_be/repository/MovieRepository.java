package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT m " +
            "FROM Movie m " +
            "WHERE m.premiereDate <= CURRENT_TIME AND m.isActive = true " +
            "ORDER BY m.id DESC ")
    Page<Movie> getPageMovieIsShowing(Pageable pageable);

    Movie findByIdAndIsActive(Integer id, Boolean isActive);

    @Query(value = "SELECT m " +
            "FROM Movie m " +
            "WHERE m.premiereDate >= CURRENT_TIME AND m.isActive = true " +
            "ORDER BY m.id DESC")
    Page<Movie> getPageUpComingMovie(Pageable pageable);

    @Query(value = "SELECT m " +
            "FROM Movie m " +
            "WHERE m.isActive = true " +
            "ORDER BY m.id DESC")
    Page<Movie> getPageMovie(Pageable pageable);
}
