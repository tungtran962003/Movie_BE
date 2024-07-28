package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.*;
import com.example.movie_web_be.repository.TicketRepository;
import com.example.movie_web_be.request.TicketRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Ticket> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return ticketRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public String generateCode() {
        Ticket ticketFinalCurrent = ticketRepository.findTopByOrderByIdDesc();
        if (ticketFinalCurrent == null) {
            return "TK000001";
        }
        Integer idFinalCurrent = ticketFinalCurrent.getId() + 1;
        String code = String.format("%05d", idFinalCurrent);
        return "TK"+code;
    }

    @Override
    public MessageResponse create(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setName(ticketRequest.getName());
        ticket.setCode(generateCode());
        ticket.setPrice(ticketRequest.getPrice());
        ticket.setIsActive(true);
        ticket.setSchedule(Schedule.builder().id(ticketRequest.getScheduleId()).build());
        ticket.setSeat(Seat.builder().id(ticketRequest.getSeatId()).build());
        ticketRepository.save(ticket);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, TicketRequest ticketRequest) {
        Ticket ticket = ticketRepository.findByIdAndIsActive(idUpdate, true);
        if (ticket != null) {
            ticket.setName(ticketRequest.getName());
            ticket.setPrice(ticketRequest.getPrice());
            ticket.setIsActive(true);
            ticket.setSchedule(Schedule.builder().id(ticketRequest.getScheduleId()).build());
            ticket.setSeat(Seat.builder().id(ticketRequest.getSeatId()).build());
            ticketRepository.save(ticket);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Ticket ticket = ticketRepository.findByIdAndIsActive(idDelete, true);
        if (ticket != null) {
            ticket.setIsActive(false);
            ticketRepository.save(ticket);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
