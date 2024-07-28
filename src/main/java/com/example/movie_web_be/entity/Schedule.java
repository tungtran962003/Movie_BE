package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "Schedule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String code;

    private Date startDate;

    private Date endDate;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "MovieId", referencedColumnName = "Id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "CinemaId", referencedColumnName = "Id")
    private Cinema cinema;
}
