package com.example.movie_web_be.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketRequest {

    private String code;

    private String name;

    private BigDecimal price;

    private Boolean isActive;

    private Integer scheduleId;

    private Integer seatId;
}
