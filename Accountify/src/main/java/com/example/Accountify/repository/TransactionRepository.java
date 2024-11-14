package com.example.Accountify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Accountify.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}