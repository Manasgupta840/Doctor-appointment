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
import com.doctor.appointment.models.Hospital;
import com.doctor.appointment.service.HospitalService;

@RestController
@RequestMapping("/api/hospital")
@CrossOrigin(origins="*")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalservice;
	
	//Post - create hospital
	@PostMapping("/doctor/{doctorId}")
	public ResponseEntity<Hospital> createhospital(@Valid @RequestBody Hospital hospital, @PathVariable("doctorId") Integer doctorId){
		
		Hospital createdhospital = this.hospitalservice.createHospital(hospital,doctorId );
		
		return new ResponseEntity<>(createdhospital, HttpStatus.CREATED);
	}
	
	//Put - Update hospital
	@PutMapping("/{hospitalId}")
	public ResponseEntity<Hospital> updatehospital(@Valid @RequestBody Hospital hospital, @PathVariable("hospitalId") Integer hospitalId){
			
			Hospital updatedhospital = this.hospitalservice.updateHospital(hospital, hospitalId);
			
			return new ResponseEntity<>(updatedhospital, HttpStatus.CREATED);
	}
	
	//Get Hospital by Id
	@GetMapping("/{hospitalId}")
	public ResponseEntity<Hospital> gethospitalById(@PathVariable("hospitalId") Integer hospitalId){
			
		Hospital hospital = this.hospitalservice.getHospitalById(hospitalId);
			
		return new ResponseEntity<>(hospital, HttpStatus.OK);
	}
	
	//Get Hospital by Id
	@GetMapping("/")
	public ResponseEntity<List<Hospital>> getAllhospital(){
				
		return new ResponseEntity<>(this.hospitalservice.getAllHospital(), HttpStatus.OK);
	}
	
	//Delete - delete user
	@DeleteMapping("/{hospitalId}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("hospitalId") Integer hospitalId){
		this.hospitalservice.deleteHospital(hospitalId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Hospital deleted Successfully",true), HttpStatus.OK);
	}
	
	//get Hospital by doctor Id 
	@GetMapping("/doctor/{doctorId}")
	public  ResponseEntity<List<Hospital>> getAllhospitalBydoctorId(@PathVariable Integer doctorId){
		
		List<Hospital> hospitals = this.hospitalservice.findByDoctor(doctorId);
		
		return new ResponseEntity<List<Hospital>>(hospitals,HttpStatus.OK);
	}
	
	//Search hospitals by city
	@GetMapping("/search/{keywords}")
	public  ResponseEntity<List<Hospital>> seachHospitalsByCity(@PathVariable("keywords") String keywords){
		
		List<Hospital> hospitals = this.hospitalservice.searchHospitalsByCity(keywords);
		return new ResponseEntity<List<Hospital>>(hospitals,HttpStatus.OK);
	}
	
}
