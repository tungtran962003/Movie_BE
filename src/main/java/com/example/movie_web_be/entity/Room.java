package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Room")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private Integer capacity;

    private String name;

    private String description;

    private String type;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "CinemaId", referencedColumnName = "Id")
    private Cinema cinema;
}
