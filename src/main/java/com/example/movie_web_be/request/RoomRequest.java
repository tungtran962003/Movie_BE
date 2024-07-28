package com.example.movie_web_be.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomRequest {

    private Integer capacity;

    private String name;

    private Integer cinemaId;
}
