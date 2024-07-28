package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Schedule;
import com.example.movie_web_be.request.RoomRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public List<Schedule> getAll() {
        return null;
    }

    @Override
    public Page<Schedule> getPage(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public MessageResponse create(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public MessageResponse update(Integer idUpdate, RoomRequest roomRequest) {
        return null;
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        return null;
    }
}
