package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.repository.RoomRepository;
import com.example.movie_web_be.request.RoomRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAll() {
        return roomRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Room> getPage(Integer page, Integer pageSize, Integer cinemaId) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return roomRepository.findAllByIsActiveAndCinema_IdOrderByIdDesc(pageable, cinemaId, true);
    }

    public Boolean checkName(String name) {
        Room room = roomRepository.findByNameAndIsActive(name, true);
        if (room != null) {
            return false;
        }
        return true;
    }

    @Override
    public MessageResponse create(RoomRequest roomRequest) {
        if (!checkName(roomRequest.getName())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Room room = new Room();
        room.setName(roomRequest.getName());
        room.setCapacity(roomRequest.getCapacity());
        room.setCinema(Cinema.builder().id(roomRequest.getCinemaId()).build());
        room.setIsActive(true);
        roomRepository.save(room);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, RoomRequest roomRequest) {
        if (!checkName(roomRequest.getName())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Room room = roomRepository.findByIdAndIsActive(idUpdate, true);
        if (room != null) {
            room.setName(roomRequest.getName());
            room.setCapacity(roomRequest.getCapacity());
            room.setCinema(Cinema.builder().id(roomRequest.getCinemaId()).build());
            room.setIsActive(true);
            roomRepository.save(room);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Room room = roomRepository.findByIdAndIsActive(idDelete, true);
        if (room != null) {
            room.setIsActive(false);
            roomRepository.save(room);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
