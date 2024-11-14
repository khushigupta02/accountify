package com.example.Accountify.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Accountify.entity.Transaction;
import com.example.Accountify.repository.TransactionRepository;
import com.example.Accountify.service.AccountService;
import com.example.Accountify.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountService accountService;
	@Override
	public Transaction createTransaction(Long accountId, Integer operationTypeId, Double amount) {
		if (operationTypeId == null) {
			throw new IllegalArgumentException("Operation Type ID cannot be null");
		}

		// Validate the amount based on operation type
		if (((operationTypeId == 1) || (operationTypeId == 3)) && (amount > 0)) {
			throw new IllegalArgumentException("Amount must be negative for 'Normal Purchase' or 'Withdrawal' operation");
		} else if ((operationTypeId == 4) && (amount < 0)) {
			throw new IllegalArgumentException("Amount must be positive for 'Credit Voucher' operation");
		}

		Transaction transaction = new Transaction();
		transaction.setAccountId(accountId);
		transaction.setOperationTypeId(operationTypeId);
		transaction.setAmount(amount);
		transaction.setEventDate(LocalDateTime.now());
		 transactionRepository.save(transaction);

		return transaction;
	}
}