package com.example.movie_web_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "BillFood")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BillFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "BillId", referencedColumnName = "Id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "FoodId", referencedColumnName = "Id")
    private Food food;
}
