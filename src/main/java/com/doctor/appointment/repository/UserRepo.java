package com.doctor.appointment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.appointment.models.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	Optional<User> findByemail(String contactdetail);
} 
