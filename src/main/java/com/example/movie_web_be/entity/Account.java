package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "Account")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String password;

    private String email;

    private String name;

    private Date createDate;

    private Date updateDate;

    private Date birthDay;

    private String phoneNumber;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "RankCustomerId", referencedColumnName = "Id")
    private RankCustomer rankCustomer;

    @ManyToOne
    @JoinColumn(name = "RoleId", referencedColumnName = "Id")
    private Role role;
}
