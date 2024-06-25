package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Seat")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "SeatStatusId", referencedColumnName = "Id")
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "SeatTypeId", referencedColumnName = "Id")
    private SeatType seatType;
}
