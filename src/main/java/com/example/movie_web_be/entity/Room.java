package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private Boolean isActive;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> listSeat;

    @ManyToOne
    @JoinColumn(name = "CinemaId", referencedColumnName = "Id")
    private Cinema cinema;
}
