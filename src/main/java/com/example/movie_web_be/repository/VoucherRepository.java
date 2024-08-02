package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Cinema;
import com.example.movie_web_be.entity.Ticket;
import com.example.movie_web_be.entity.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

    List<Voucher> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Voucher> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Voucher findByNameAndIsActive(String name, Boolean isActive);

    Voucher findByIdAndIsActive(Integer id, Boolean isActive);

    Voucher findTopByOrderByIdDesc();
}
