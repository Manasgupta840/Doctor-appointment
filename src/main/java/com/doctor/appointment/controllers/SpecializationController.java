package com.doctor.appointment.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.appointment.config.ApiResponse;
import com.doctor.appointment.models.Specialization;
import com.doctor.appointment.service.SpecializationService;

@RestController
@RequestMapping("/api/specilazation")
@CrossOrigin(origins="*")
public class SpecializationController {
	
	@Autowired
	private SpecializationService specializationservice;
	
	
	//Post -create specialization
	@PostMapping("/doctor/{doctorId}")
	public ResponseEntity<Specialization> createspecialization(@Valid @RequestBody Specialization specialization,@PathVariable("doctorID")Integer doctorId){
		Specialization createdspecialization=this.specializationservice.createSpecialization(specialization, doctorId);
		return new ResponseEntity<>(createdspecialization,HttpStatus.CREATED);
	}
	
	//Put- Update specialization
	@PutMapping("/{specializationId}")
	public ResponseEntity<Specialization> updatespecialization(@Valid @RequestBody Specialization specialization, @PathVariable("specializationId") Integer specializationId){
		Specialization updatedspecialization=this.specializationservice.updateSpecialization(specialization, specializationId);
		return new ResponseEntity<>(updatedspecialization, HttpStatus.CREATED);
	}
	
	// Get specialization by Id
	@GetMapping("/{specializationId}")
	public ResponseEntity<Specialization> getspecializationById(@PathVariable("specializationId") Integer specializationId){
		Specialization specialization=this.specializationservice.getSpecializationById(specializationId);
		
		return new ResponseEntity<>(specialization,HttpStatus.OK);
	}
	
	
	// Delete- delete  user
	@DeleteMapping("/{specializationId}")
	public ResponseEntity<ApiResponse>deleteSpecialization(@PathVariable("specializationId") Integer specializationId){
		this.specializationservice.deleteSpecialization(specializationId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Specialization deleted successfully",true), HttpStatus.OK);
		
	}
	
	//Search specialization by name
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<Specialization>>searchspecializationByName(@PathVariable("keywords") String keywords){
		List<Specialization> specialization=this.specializationservice.searchSpecializationByName(keywords);
		return new ResponseEntity<List<Specialization>>(specialization,HttpStatus.OK);
	}

}