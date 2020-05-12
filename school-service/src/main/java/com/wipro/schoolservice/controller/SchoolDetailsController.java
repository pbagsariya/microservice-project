package com.wipro.schoolservice.controller;

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
import com.wipro.schoolservice.model.School;

@RestController
@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SchoolDetailsController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/schools/add")
	public School addAccount(@RequestBody School school) {
		School result = restTemplate.postForObject("http://DATA-SERVICE/schools/add", school, School.class);
		return result;

	}

	@GetMapping(value = "/schools/getAllSchools")
	public String getAccounts() {
		String response = restTemplate.exchange("http://DATA-SERVICE/schools/getall/", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();

		System.out.println("Response Received as " + response);

		return response;
	}

	@PutMapping(value = "/schools/delete")
	public School deleteAccount(School school) {
		School result = restTemplate.postForObject("http://DATA-SERVICE/schools/delete", school, School.class);
		return result;

	}
	
	
	@PutMapping(value = "/schools/update")
	public School updateSchool(@RequestBody School school) {
		School result = restTemplate.postForObject("http://DATA-SERVICE/schools/update", school, School.class);
		return result;
		

	}

}
