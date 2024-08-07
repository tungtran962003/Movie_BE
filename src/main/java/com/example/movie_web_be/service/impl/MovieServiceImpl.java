package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.entity.MovieType;
import com.example.movie_web_be.repository.MovieRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.MovieService;
import com.example.movie_web_be.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final String uploadDir = "./src/main/resources/static/assets/movie/";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<Movie> getPageMovie(Integer size, Integer pageSize) {
        Pageable pageable = PageRequest.of(size, pageSize);
        return movieRepository.getPageMovie(pageable);
    }

    @Override
    public Page<Movie> getPageMovieIsShowing(Integer size, Integer pageSize) {
        Pageable pageable = PageRequest.of(size, pageSize);
        return movieRepository.getPageMovieIsShowing(pageable);
    }
//
    @Override
    public Page<Movie> getPageUpComingMovie(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return movieRepository.getPageUpComingMovie(pageable);
    }

    @Override
    public List<Movie> getListMovieIsShowing() {
        List<Movie> listMovieHomeResponse = new ArrayList<>();
        List<Movie> listMovieIsShowIng = movieRepository.getListMovieIsShowIng();
        int index = 1;
        for (Movie movie: listMovieIsShowIng) {
            if (index <= 8) {
                listMovieHomeResponse.add(movie);
                index++;
            }
        }
        return listMovieHomeResponse;
    }

    @Override
    public List<Movie> getListUpComingMovie() {
        List<Movie> listMovieHomeResponse = new ArrayList<>();
        List<Movie> listUpComingMovie = movieRepository.getListUpComingMovie();
        int index = 1;
        for (Movie movie: listUpComingMovie) {
            if (index <= 8) {
                listMovieHomeResponse.add(movie);
                index++;
            }
        }
        return listMovieHomeResponse;
    }


    @Override
    public MessageResponse create(String name, Integer time, String premiereDate, String description, String director,
                                  String language, String performer, Integer movieTypeId, String trailer, MultipartFile file) throws ParseException {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setTime(time);
        movie.setPremiereDate(sdf.parse(premiereDate));
        movie.setDescription(description);
        movie.setDirector(director);
        movie.setLanguage(language);
        movie.setPerformer(performer);
        movie.setTrailer(trailer);
        movie.setIsActive(true);
        movie.setMovieType(MovieType.builder().id(movieTypeId).build());
        String fileName = file.getOriginalFilename();
        String extension = FileUtil.getFileExtension(fileName);
        String newFileName = "movie" + new Date().getTime() + "." + extension;
        FileUtil.copyFile(file, newFileName, uploadDir);
        movie.setImage(newFileName);
        movieRepository.save(movie);
        return new MessageResponse("Thêm mới dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, String name, Integer time, String premiereDate, String description, String director,
                                  String language, String performer, Integer movieTypeId, String trailer, MultipartFile file) throws ParseException {
        Movie movie = movieRepository.findByIdAndIsActive(idUpdate, true);
        if (movie != null) {
            movie.setName(name);
            movie.setTime(time);
            movie.setPremiereDate(sdf.parse(premiereDate));
            movie.setDescription(description);
            movie.setDirector(director);
            movie.setLanguage(language);
            movie.setPerformer(performer);
            movie.setTrailer(trailer);
            movie.setIsActive(true);
            movie.setMovieType(MovieType.builder().id(movieTypeId).build());
            if (file != null) {
                String fileName = file.getOriginalFilename();
                String extension = FileUtil.getFileExtension(fileName);
                String newFileName = "movie" + new Date().getTime() + "." + extension;
                FileUtil.copyFile(file, newFileName, uploadDir);
                movie.setImage(newFileName);
            }
            movieRepository.save(movie);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Dữ liệu không tồn tại", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Movie movie = movieRepository.findByIdAndIsActive(idDelete, true);
        if (movie != null) {
            movie.setIsActive(false);
            movieRepository.save(movie);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Dữ liệu không tồn tại", 1);
    }

    @Override
    public Page<Movie> search(Integer page, Integer pageSize, String name, String startDateStr, String endDateStr, String director, String language, String performer, Integer movieTypeId) throws ParseException {
        Pageable pageable = PageRequest.of(page, pageSize);
        Date startDate = null;
        Date endDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if ("".equals(startDateStr)) {
            startDate = sdf.parse("0000-01-01");
        }
        if ("".equals(endDateStr)) {
            endDate = sdf.parse("9999-12-31");
        }
        Page<Movie> pageMovie = movieRepository.searchMovie(pageable, name, startDate, endDate, language, director, performer, movieTypeId);
        return pageMovie;
    }
}
