package com.wipro.dataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dataservice.entity.Student;
import com.wipro.dataservice.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public Student saveStudent(Student st) {
		repository.save(st);
		return st;

	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	public Student deleteStudent(Student student) {
		repository.delete(student);
		return student;

	}

}
