package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "SeatStatus")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SeatStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String name;

    private Boolean isActive;
}
