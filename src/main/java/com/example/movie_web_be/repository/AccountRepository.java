package com.example.movie_web_be.repository;

import com.example.movie_web_be.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByEmail(String email);

    Boolean existsAccountByEmail(String email);

    Page<Account> findAllByIsActiveOrderByUpdateDateDesc(Pageable pageable, Boolean isActive);
}
