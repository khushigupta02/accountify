package com.example.Accountify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Accountify.entity.Account;
import com.example.Accountify.repository.AccountRepository;
import com.example.Accountify.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(String documentNumber) {
		Account account = new Account();
		account.setDocumentNumber(documentNumber);
		return accountRepository.save(account);
	}


	@Override
	public Account getAccountById(Long accountId) {
		return accountRepository.findById(accountId)
								.orElseThrow(() -> new RuntimeException("Account not found"));
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
}