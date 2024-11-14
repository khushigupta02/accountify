package com.example.Accountify.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.example.Accountify.entity.Transaction;

public interface TransactionService {
	 Transaction createTransaction(Long accountId, Integer operationTypeId, Double amount) ;
}