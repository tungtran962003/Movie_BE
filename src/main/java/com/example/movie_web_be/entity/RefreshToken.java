package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "RefreshToken")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String token;

    private Date expiredTime;

    @ManyToOne
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    private Account account;
}
