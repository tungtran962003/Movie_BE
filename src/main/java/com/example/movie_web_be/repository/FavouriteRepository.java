package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Favourite;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {

//    Page<Favourite> findAll();
}
