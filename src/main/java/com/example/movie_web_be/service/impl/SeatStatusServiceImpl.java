package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.MovieType;
import com.example.movie_web_be.entity.SeatStatus;
import com.example.movie_web_be.repository.SeatStatusRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatStatusServiceImpl implements SeatStatusService {

    @Autowired
    private SeatStatusRepository seatStatusRepository;

    @Override
    public List<SeatStatus> getAll() {
        return seatStatusRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<SeatStatus> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return seatStatusRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkName(String name) {
        SeatStatus seatStatus = seatStatusRepository.findByNameAndIsActive(name, true);
        if (seatStatus != null) {
            return false;
        }
        return true;
    }

    @Override
    public MessageResponse create(String name) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        SeatStatus seatStatus = new SeatStatus();
        seatStatus.setName(name);
        seatStatus.setIsActive(true);
        seatStatusRepository.save(seatStatus);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, String name) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        SeatStatus seatStatus = seatStatusRepository.findByIdAndIsActive(idUpdate, true);
        if (seatStatus != null) {
            seatStatus.setName(name);
            seatStatusRepository.save(seatStatus);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        SeatStatus seatStatus = seatStatusRepository.findByIdAndIsActive(idDelete, true);
        if (seatStatus != null) {
            seatStatus.setIsActive(false);
            seatStatusRepository.save(seatStatus);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
