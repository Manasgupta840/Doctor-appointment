package com.doctor.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doctor.appointment.models.Hospital;
import com.doctor.appointment.models.User;




public interface HospitalRepo extends JpaRepository<Hospital, Integer>  {
	
	List<Hospital> findByUser(User user);
	
	@Query("select p from Hospital p where p.city like :key")
	List<Hospital> searchByCity( @Param("key") String city);
	

	
}
