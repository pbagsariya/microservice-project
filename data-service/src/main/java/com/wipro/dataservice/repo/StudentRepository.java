package com.wipro.dataservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wipro.dataservice.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
