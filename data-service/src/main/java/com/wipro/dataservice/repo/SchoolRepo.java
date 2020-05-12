package com.wipro.dataservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.dataservice.entity.School;

public interface SchoolRepo extends JpaRepository<School, Long> {
	@Modifying
	@Query("UPDATE School s SET s.name = :n ,s.location = :l, s.mediume = :m WHERE s.id = :id")
	int updateAddress(@Param("id") Long schoolId, @Param("n") String name, @Param("l") String location,
			@Param("m") String mediume);

}
