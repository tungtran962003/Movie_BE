package com.example.movie_web_be.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class VoucherRequest {

    private String name;

    private Date startDate;

    private Date endDate;

    private Integer quantity;

    private BigDecimal minimumPrice;
}
