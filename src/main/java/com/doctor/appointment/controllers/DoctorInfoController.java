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
import com.doctor.appointment.models.DoctorInfo;
import com.doctor.appointment.models.Hospital;
import com.doctor.appointment.service.DoctorInfoService;

@RestController
@RequestMapping("/api/doctor-info")
@CrossOrigin(origins="*")
public class DoctorInfoController {
	
	@Autowired
	private DoctorInfoService doctorInfoservice;
	
	//Post - create doctorInfo
		@PostMapping("/doctor/{doctorId}")
		public ResponseEntity<DoctorInfo> createdoctorInfo(@Valid @RequestBody DoctorInfo doctorInfo, @PathVariable("doctorId") Integer doctorId){
			
			DoctorInfo createddoctorInfo = this.doctorInfoservice.createDoctorInfo(doctorInfo,doctorId );
			
			return new ResponseEntity<>(createddoctorInfo, HttpStatus.CREATED);
		}
		
		//Put - Update doctorInfo
		@PutMapping("/{doctorInfoId}")
		public ResponseEntity<DoctorInfo> updatedoctorInfo(@Valid @RequestBody DoctorInfo doctorInfo, @PathVariable("doctorInfoId") Integer doctorInfoId){
				
				DoctorInfo updateddoctorInfo = this.doctorInfoservice.updateDoctorInfo(doctorInfo, doctorInfoId);
				
				return new ResponseEntity<>(updateddoctorInfo, HttpStatus.CREATED);
		}
		
		//Get DoctorInfo by Id
		@GetMapping("/{doctorInfoId}")
		public ResponseEntity<DoctorInfo> getdoctorInfoById(@PathVariable("doctorInfoId") Integer doctorInfoId){
				
			DoctorInfo doctorInfo = this.doctorInfoservice.getDoctorInfoById(doctorInfoId);
				
			return new ResponseEntity<>(doctorInfo, HttpStatus.OK);
		}
		
		//Get DoctorInfo by Id
		@GetMapping("/")
		public ResponseEntity<List<DoctorInfo>> getAlldoctorInfo(){
					
			return new ResponseEntity<>(this.doctorInfoservice.getAllDoctorInfo(), HttpStatus.OK);
		}
		
		//Delete - delete user
		@DeleteMapping("/{doctorInfoId}")
		public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("doctorInfoId") Integer doctorInfoId){
			this.doctorInfoservice.deleteDoctorInfo(doctorInfoId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("DoctorInfo deleted Successfully",true), HttpStatus.OK);
		}
		
		//Search hospitals by city
		@GetMapping("/search/{keywords}")
		public  ResponseEntity<List<DoctorInfo>> seachDoctorsByOverallExperience(@PathVariable("keywords") Integer keywords){
			
			List<DoctorInfo> doctorInfo = this.doctorInfoservice.findByOverallExperience(keywords);
			return new ResponseEntity<List<DoctorInfo>>(doctorInfo,HttpStatus.OK);
		}
		
	

}
