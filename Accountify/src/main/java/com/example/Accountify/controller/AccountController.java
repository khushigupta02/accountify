package com.example.Accountify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Accountify.entity.Account;
import com.example.Accountify.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.createAccount(account.getDocumentNumber()));
	}

	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
		Account account = accountService.getAccountById(accountId);
		return ResponseEntity.ok(account);
	}
	@GetMapping("/getAll")
	public List<Account> getAllAccount(){
		List<Account> accounts = accountService.getAllAccount();
		return ResponseEntity.ok(accounts)
							 .getBody();
	}
}