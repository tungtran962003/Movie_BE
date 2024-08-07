package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "Movie")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String name;

    private String trailer;

    private Integer time;

    private Date premiereDate;

    @Column(columnDefinition="TEXT")
    private String description;

    private String director;

    private String image;

    private String language;

    private Boolean isActive;

    private String performer;

    @ManyToOne
    @JoinColumn(name = "MovieTypeId", referencedColumnName = "Id")
    private MovieType movieType;
}
