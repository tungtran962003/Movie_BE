package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.MovieType;
import com.example.movie_web_be.repository.MovieTypeRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    @Autowired
    private MovieTypeRepository movieTypeRepository;

    @Override
    public List<MovieType> getAll() {
        return movieTypeRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<MovieType> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return movieTypeRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkName(String name) {
        MovieType movieType = movieTypeRepository.findByNameAndIsActive(name, true);
        if (movieType != null) {
            return false;
        }
        return true;
    }

//    @Override
//    public Boolean create(MovieTypeRequest movieTypeRequest) {
//        if (!checkNameMovieType(movieTypeRequest.getName())) {
//            return false;
//        }
//        MovieType movieType = movieTypeRequest.create(new MovieType());
//        movieTypeRepository.save(movieType);
//        return true;
//    }

    @Override
    public MessageResponse create(String name) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        MovieType movieType = new MovieType();
        movieType.setName(name);
        movieType.setIsActive(true);
        movieTypeRepository.save(movieType);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, String name) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        MovieType movieType = movieTypeRepository.findByIdAndIsActive(idUpdate, true);
        if (movieType != null) {
            movieType.setName(name);
            movieTypeRepository.save(movieType);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        MovieType movieType = movieTypeRepository.findByIdAndIsActive(idDelete, true);
        if (movieType != null) {
            movieType.setIsActive(false);
            movieTypeRepository.save(movieType);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
