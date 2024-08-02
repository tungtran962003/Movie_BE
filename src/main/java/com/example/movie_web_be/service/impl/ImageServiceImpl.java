package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Account;
import com.example.movie_web_be.entity.Movie;
import com.example.movie_web_be.repository.AccountRepository;
import com.example.movie_web_be.repository.MovieRepository;
import com.example.movie_web_be.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AccountRepository accountRepository;

    private byte[] convert(String imagePath) throws IOException {
        // Create a FileInputStream object to read the image file.
        FileInputStream fis = new FileInputStream(imagePath);

        // Create a ByteArrayOutputStream object to store the image data in bytes.
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // Read the image data from the FileInputStream object and write it to the ByteArrayOutputStream object.
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        // Close the FileInputStream and ByteArrayOutputStream objects.
        fis.close();
        bos.close();

        // Get the byte array containing the image data from the ByteArrayOutputStream object.
        byte[] imageData = bos.toByteArray();
        return imageData;
    }

    private String getImagePath(String fileName, String entityString) {
        String currentProjectPath = System.getProperty("user.dir");
        String newPath = currentProjectPath + File.separator + "src/main/resources/static/assets/" + entityString
                + File.separator + fileName;

        return newPath;
    }

    @Override
    public byte[] getImageMovie(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie == null) {
            log.info("movie image id = {} is not exist on DB", movieId);
            return null;
        }
        try {
            return convert(getImagePath(movie.getImage(), "movie"));
        } catch (IOException e) {
            log.error("Convert image fail, movie image id = {}", movieId);
            return null;
        }
    }

    @Override
    public byte[] getAvatarAccount(Integer accountId) {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) {
            log.info("account image id = {} is not exist on DB", accountId);
            return null;
        }
        try {
            return convert(getImagePath(account.getAvatar(), "avatar"));
        } catch (IOException e) {
            log.error("Convert image fail, account image id = {}", accountId);
            return null;
        }
    }
}
