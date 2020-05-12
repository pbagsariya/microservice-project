package com.wipro.dataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dataservice.entity.Account;
import com.wipro.dataservice.repo.AccountsRepository;

@Service
public class AccountService {

	@Autowired
	private AccountsRepository accountsRepository;

	public Account saveAccount(Account a) {
		accountsRepository.save(a);
		return a;

	}

	public List<Account> getAllAccounts() {
		return accountsRepository.findAll();
	}

	public Account deleteAccount(Account accountObject) {
		accountsRepository.delete(accountObject);
		return accountObject;

	}

	public Account findById(Long id) {
		return accountsRepository.findById(id).get();
	}

	public Account updateAccount(Account acc) {
		accountsRepository.updateAddress(acc.getId(), acc.getType(), acc.getNumber(), acc.getHolderName(),
				acc.getAcBal());
		return acc;
	}

}
