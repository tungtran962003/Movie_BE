package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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


    @Query(value = "SELECT m " +
            "FROM Movie m " +
            "WHERE m.premiereDate <= CURRENT_TIME AND m.isActive = true " +
            "ORDER BY m.id DESC")
    List<Movie> getListMovieIsShowIng();

    @Query(value = "SELECT m " +
            "FROM Movie m " +
            "WHERE m.premiereDate >= CURRENT_TIME AND m.isActive = true " +
            "ORDER BY m.id DESC")
    List<Movie> getListUpComingMovie();

    @Query(value = "SELECT m " +
            "FROM Movie m " +
            "WHERE (m.name LIKE %:name% OR m.name IS NULL) " +
            "AND (m.premiereDate BETWEEN :startDate AND :endDate) " +
            "AND (m.language LIKE %:language% OR m.language IS NULL) " +
            "AND (m.director LIKE %:director% OR m.director IS NULL) " +
            "AND (m.performer LIKE %:performer% OR m.performer IS NULL) " +
            "AND (m.movieType.id=:movieTypeId OR :movieTypeId IS NULL) " +
            "AND m.isActive = true ORDER BY m.id DESC")
    Page<Movie> searchMovie(Pageable pageable, String name, Date startDate, Date endDate, String language, String director, String performer, Integer movieTypeId);
}
