package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Ticket> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Ticket findByNameAndIsActive(String name, Boolean isActive);

    Ticket findByIdAndIsActive(Integer id, Boolean isActive);

    Ticket findTopByOrderByIdDesc();
}
