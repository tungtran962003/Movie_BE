package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.entity.Ticket;
import com.example.movie_web_be.request.RoomRequest;
import com.example.movie_web_be.request.TicketRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    Page<Ticket> getPage(Integer page, Integer pageSize);

    MessageResponse create(TicketRequest ticketRequest);

    MessageResponse update(Integer idUpdate, TicketRequest ticketRequest);

    MessageResponse delete(Integer idDelete);
}
