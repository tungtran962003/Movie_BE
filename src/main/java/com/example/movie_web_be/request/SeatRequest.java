package com.example.movie_web_be.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatRequest {

    private String code;

    private String line;

    private Boolean isActive;

    private Integer seatStatusId;

    private Integer seatTypeId;

    private Integer roomId;
}
