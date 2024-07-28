package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.*;
import com.example.movie_web_be.repository.SeatRepository;
import com.example.movie_web_be.request.SeatRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getAll() {
        return seatRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Seat> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return seatRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkName(String code) {
        Seat seat = seatRepository.findByCodeAndIsActive(code, true);
        if (seat != null) {
            return false;
        }
        return true;
    }

    @Override
    public MessageResponse create(SeatRequest seatRequest) {
        if (!checkName(seatRequest.getCode())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Seat seat = new Seat();
        seat.setCode(seatRequest.getCode());
        seat.setLine(seatRequest.getLine());
        seat.setIsActive(true);
        seat.setRoom(Room.builder().id(seatRequest.getRoomId()).build());
        seat.setSeatStatus(SeatStatus.builder().id(seatRequest.getSeatStatusId()).build());
        seat.setSeatType(SeatType.builder().id(seatRequest.getSeatTypeId()).build());
        seatRepository.save(seat);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, SeatRequest seatRequest) {
        if (!checkName(seatRequest.getCode())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Seat seat = seatRepository.findByIdAndIsActive(idUpdate, true);
        if (seat != null) {
            seat.setCode(seatRequest.getCode());
            seat.setLine(seatRequest.getLine());
            seat.setIsActive(true);
            seat.setRoom(Room.builder().id(seatRequest.getRoomId()).build());
            seat.setSeatStatus(SeatStatus.builder().id(seatRequest.getSeatStatusId()).build());
            seat.setSeatType(SeatType.builder().id(seatRequest.getSeatTypeId()).build());
            seatRepository.save(seat);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Seat seat = seatRepository.findByIdAndIsActive(idDelete, true);
        if (seat != null) {
            seat.setIsActive(false);
            seatRepository.save(seat);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
