package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "Bill")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String code;

    private Date createDate;

    private Date updateDate;

    private Date paymentDate;

    private BigDecimal totalMoney;

    private String description;

    private String phoneNumber;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "VoucherId", referencedColumnName = "Id")
    private Voucher voucher;
}
