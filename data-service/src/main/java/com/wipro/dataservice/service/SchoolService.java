package com.wipro.dataservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dataservice.entity.School;
import com.wipro.dataservice.repo.SchoolRepo;

@Service
public class SchoolService {
	@Autowired
	private SchoolRepo schoolRepo;

	public School saveSchool(School s) {
		schoolRepo.save(s);
		return s;

	}
	
	public School findById(Long id) {
		Optional<School> school=schoolRepo.findById(id);
		return school.get();
	}

	public List<School> getAllSchools() {
		return schoolRepo.findAll();
	}

	public School deleteSchool(School schoolObject) {
		schoolRepo.delete(schoolObject);
		return schoolObject;

	}

	public School updateSchool(School school) {
		schoolRepo.updateAddress(school.getId(), school.getName(), school.getLocation(), school.getMediume());
		return school;
	}

}
