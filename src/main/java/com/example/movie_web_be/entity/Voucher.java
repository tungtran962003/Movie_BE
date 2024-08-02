package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "Voucher")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String code;

    private String name;

    private Date startDate;

    private Date endDate;

    private Integer quantity;

    private BigDecimal minimumPrice;

    private Boolean isActive;

}
