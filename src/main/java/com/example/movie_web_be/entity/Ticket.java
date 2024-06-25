package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "Ticket")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String code;

    private String name;

    private BigDecimal price;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "ScheduleId", referencedColumnName = "Id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "SeatId", referencedColumnName = "Id")
    private Seat seat;
}
