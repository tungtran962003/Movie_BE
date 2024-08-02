package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByEmail(String email);

    Boolean existsAccountByEmail(String email);

    Boolean existsAccountByPhoneNumber(String phoneNumber);

    List<Account> findAllByIsActiveOrderByIdDesc(Boolean isActive);

    Page<Account> findAllByIsActiveOrderByIdDesc(Pageable pageable, Boolean isActive);

    Account findByNameAndIsActive(String name, Boolean isActive);

    Account findByIdAndIsActive(Integer id, Boolean isActive);
}
