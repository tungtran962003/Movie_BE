package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "Promotion")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String name;

    private Integer percent;

    private Integer quantity;

    private Date startDate;

    private Date endDate;

    private String description;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "RankCustomerId", referencedColumnName = "Id")
    private RankCustomer rankCustomer;
}
