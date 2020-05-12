package com.wipro.dataservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dataservice.entity.Account;
import com.wipro.dataservice.entity.School;
import com.wipro.dataservice.entity.Student;
import com.wipro.dataservice.service.AccountService;
import com.wipro.dataservice.service.SchoolService;
import com.wipro.dataservice.service.StudentService;

@RestController
@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DataController {

	@Autowired
	SchoolService schoolService;
	@Autowired
	StudentService studentService;
	@Autowired
	AccountService accountService;

	@PostMapping(value = "/schools/add")
	public School addSchool(@RequestBody School schoolObject) {
		schoolService.saveSchool(schoolObject);
		return schoolObject;

	}

	@GetMapping(value = "/schools/getall")
	public List<School> getAllSchools() {
		List<School> allSchools = new ArrayList<School>();
		allSchools=schoolService.getAllSchools();
		return allSchools;

	}

	@PutMapping(value = "/schools/delete")
	public School deletSchool(@RequestBody School school) {
		schoolService.deleteSchool(school);
		return school;

	}

	@PutMapping(value = "/schools/update")
	public School updateSchool(@RequestBody School school) {
		schoolService.updateSchool(school);
		return schoolService.findById(school.getId());

	}

	// ----------------------------------------------------------------------

	@PostMapping(value = "/students/add")
	public Student addStudent(@RequestBody Student studentObject) {
		studentService.saveStudent(studentObject);
		return studentObject;

	}

	@GetMapping(value = "/students/getall")
	public List<Student> getAllAtudents() {
		List<Student> allStudents = new ArrayList<Student>();
		allStudents=studentService.getAllStudents();
		return allStudents;

	}

	@PutMapping(value = "/students/delete")
	public Student deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
		return student;
	}

	// --------------------------------------------------------------

	@PostMapping(value = "/accounts/add")
	public Account addAccount(@RequestBody Account accountObj) {
		accountService.saveAccount(accountObj);
		return accountObj;

	}

	@GetMapping(value = "/accounts/getall")
	public List<Account> getAllAccounts() {
		List<Account> allAccounts = accountService.getAllAccounts();
		return allAccounts;

	}

	@PutMapping(value = "/accounts/delete")
	public Account deleteAccount(Account account) {
		accountService.deleteAccount(account);
		return account;
	}

	@PutMapping(value = "/accounts/update")
	public Account updateAccount(Account account) {
		accountService.updateAccount(account);
		return accountService.findById(account.getId());

	}

}
