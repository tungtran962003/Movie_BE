package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.SeatStatus;
import com.example.movie_web_be.entity.SeatType;
import com.example.movie_web_be.repository.SeatTypeRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

    @Autowired
    private SeatTypeRepository seatTypeRepository;

    @Override
    public List<SeatType> getAll() {
        return seatTypeRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    public Boolean checkName(String name) {
        SeatType seatType = seatTypeRepository.findByNameAndIsActive(name, true);
        if (seatType != null) {
            return false;
        }
        return true;
    }

    @Override
    public Page<SeatType> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return seatTypeRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    @Override
    public MessageResponse create(String name, BigDecimal price) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        SeatType seatType = new SeatType();
        seatType.setPrice(price);
        seatType.setName(name);
        seatType.setIsActive(true);
        seatTypeRepository.save(seatType);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, String name, BigDecimal price) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        SeatType seatType = seatTypeRepository.findByIdAndIsActive(idUpdate, true);
        if (seatType != null) {
            seatType.setName(name);
            seatType.setPrice(price);
            seatTypeRepository.save(seatType);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        SeatType seatType = seatTypeRepository.findByIdAndIsActive(idDelete, true);
        if (seatType != null) {
            seatType.setIsActive(false);
            seatTypeRepository.save(seatType);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
