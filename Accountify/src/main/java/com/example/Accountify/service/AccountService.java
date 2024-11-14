package com.example.Accountify.service;

import java.util.List;

import com.example.Accountify.entity.Account;

public interface AccountService {
	 Account createAccount(String documentNumber) ;
	 Account getAccountById(Long accountId);
	 List<Account> getAllAccount();
}