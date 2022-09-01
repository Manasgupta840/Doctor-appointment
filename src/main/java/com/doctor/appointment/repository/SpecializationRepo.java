package com.doctor.appointment.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doctor.appointment.models.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Integer>{
	
	
	@Query("select p from Specialization p where p.name like:key")
	List<Specialization>searchBySpecializationname(@Param("key") String name);
	

}