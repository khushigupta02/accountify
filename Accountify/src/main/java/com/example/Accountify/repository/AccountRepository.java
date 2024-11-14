package com.example.Accountify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Accountify.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}