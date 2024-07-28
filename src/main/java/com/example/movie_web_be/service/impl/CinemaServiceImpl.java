package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.repository.CinemaRepository;
import com.example.movie_web_be.request.CinemaRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Cinema> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return cinemaRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkName(String name) {
        Cinema cinema = cinemaRepository.findByNameAndIsActive(name, true);
        if (cinema != null) {
            return false;
        }
        return true;
    }

    @Override
    public MessageResponse create(CinemaRequest cinemaRequest) {
        if (!checkName(cinemaRequest.getName())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Cinema cinema = new Cinema();
        cinema.setName(cinemaRequest.getName());
        cinema.setCreateDate(new Date());
        cinema.setUpdateDate(new Date());
        cinema.setIsActive(true);
        cinema.setHotline(cinemaRequest.getHotline());
        cinema.setAddress(cinemaRequest.getAddress());
        cinemaRepository.save(cinema);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, CinemaRequest cinemaRequest) {
        if (!checkName(cinemaRequest.getName())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Cinema cinema = cinemaRepository.findByIdAndIsActive(idUpdate, true);
        if (cinema != null) {
            cinema.setName(cinemaRequest.getName());
            cinema.setCreateDate(new Date());
            cinema.setUpdateDate(new Date());
            cinema.setIsActive(true);
            cinema.setHotline(cinemaRequest.getHotline());
            cinema.setAddress(cinemaRequest.getAddress());
            cinemaRepository.save(cinema);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Cinema cinema = cinemaRepository.findByIdAndIsActive(idDelete, true);
        if (cinema != null) {
            cinema.setIsActive(false);
            cinemaRepository.save(cinema);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public Page<Room> getPageRoomByCinemaId(Integer cinemaId, Integer page, Integer pageSize) {
        List<Room> listRoomByCinemaId = cinemaRepository.getListRoomByCinemaId(cinemaId);
        Pageable pageable = PageRequest.of(page, pageSize);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listRoomByCinemaId.size());
        List<Room> pageContent = listRoomByCinemaId.subList(start, end);
        return new PageImpl<>(pageContent, pageable, listRoomByCinemaId.size());
    }
}
