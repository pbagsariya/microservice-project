package com.wipro.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.accountservice.model.Account;

@RestController
@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AccountDetailsController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/accounts/add")
	public Account addAccount(@RequestBody Account account) {
		Account result = restTemplate.postForObject("http://DATA-SERVICE/accounts/add", account, Account.class);
		return result;

	}

	@GetMapping(value = "/accounts/getAllAccounts")
	public String getAccounts() {
		System.out.println("Getting Accounts details for");
		String response = restTemplate.exchange("http://DATA-SERVICE/accounts/getall/", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();

		System.out.println("Response Received as " + response);

		return response;
	}

	@PutMapping(value = "/accounts/delete")
	public Account deleteAccount(Account account) {
		Account result = restTemplate.postForObject("http://DATA-SERVICE/accounts/delete", account, Account.class);
		return result;
		
	}
	
	
	
	@PutMapping(value = "/accounts/update")
	public Account updateAccount(Account account) {
		Account result = restTemplate.postForObject("http://DATA-SERVICE/accounts/update", account, Account.class);
		return result;
		
	}

}
