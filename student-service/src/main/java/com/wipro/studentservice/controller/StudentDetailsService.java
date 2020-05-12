package com.wipro.studentservice.controller;

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

import com.wipro.studentservice.model.Student;

@RestController
@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class StudentDetailsService {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/students/add")
	public Student addAccount(@RequestBody Student student) {

		Student result = restTemplate.postForObject("http://DATA-SERVICE/students/add", student, Student.class);

		return result;

	}

	@GetMapping(value = "/students/getAllStudents")
	public String getStudents() {

		String response = restTemplate.exchange("http://DATA-SERVICE/students/getall/", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();

		return response;
	}

	@PutMapping(value = "/students/delete")
	public Student deleteAccount(Student student) {
		Student result = restTemplate.postForObject("http://DATA-SERVICE/students/delete", student, Student.class);
		return result;

	}

}
