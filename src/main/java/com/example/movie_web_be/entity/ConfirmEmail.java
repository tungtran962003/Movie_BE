package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "ConfirmEmail")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ConfirmEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private Date expiredTime;

    private String confirmCode;

    private Boolean isConfirm;

    @ManyToOne
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    private Account account;
}
