package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.RankCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankCustomerRepository extends JpaRepository<RankCustomer, Integer> {

    List<RankCustomer> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<RankCustomer> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    RankCustomer findByNameAndIsActive(String name, Boolean isActive);

    RankCustomer findByIdAndIsActive(Integer id, Boolean isActive);
}
