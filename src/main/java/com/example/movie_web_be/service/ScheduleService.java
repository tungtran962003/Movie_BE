package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Room;
import com.example.movie_web_be.entity.Schedule;
import com.example.movie_web_be.request.RoomRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAll();

    Page<Schedule> getPage(Integer page, Integer pageSize);

    MessageResponse create(RoomRequest roomRequest);

    MessageResponse update(Integer idUpdate, RoomRequest roomRequest);

    MessageResponse delete(Integer idDelete);
}
