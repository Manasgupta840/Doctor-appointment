package com.doctor.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.appointment.exceptions.ResourceNotFoundException;
import com.doctor.appointment.models.Hospital;
import com.doctor.appointment.models.User;
import com.doctor.appointment.repository.HospitalRepo;
import com.doctor.appointment.repository.UserRepo;


@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	public Hospital createHospital(Hospital hospital,Integer userId) {
		
		User doctor = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id", userId)); 
		System.out.println(hospital.getLocation());
		hospital.setUser(doctor);
		
		return this.hospitalRepo.save(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital , Integer hospitalId) {
		Hospital oldhospital = this.hospitalRepo.findById(hospitalId).orElseThrow(()-> new ResourceNotFoundException("Hospital","Hospital id", hospitalId));
		oldhospital.setCity(hospital.getCity());
		oldhospital.setLandmark(hospital.getLandmark());
		oldhospital.setLocation(hospital.getLocation());
		oldhospital.setName(hospital.getName());
		Hospital updatedhospital = this.hospitalRepo.save(oldhospital);
		return updatedhospital;
	}
	
	public Hospital getHospitalById(Integer hospitalId) {
		Hospital hospital = this.hospitalRepo.findById(hospitalId).orElseThrow(()-> new ResourceNotFoundException("Hospital","Hospital id", hospitalId));
		return hospital;
		
	}
	
	public List<Hospital> getAllHospital(){
		List<Hospital> hospital  = this.hospitalRepo.findAll();
		return hospital;
		
	}
	
	public void deleteHospital(Integer hospitalId) {
		Hospital hospital = this.hospitalRepo.findById(hospitalId).orElseThrow(()-> new ResourceNotFoundException("Hospital","Hospital id", hospitalId));
		
		this.hospitalRepo.delete(hospital);
		
	}
	
	public List<Hospital> findByDoctor(Integer doctorId) {
		
		User doctor = this.userRepo.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("User","User id", doctorId)); 
		
		List<Hospital> hospitals = this.hospitalRepo.findByUser(doctor);
		
		return hospitals;
		
	}
	
	public List<Hospital> searchHospitalsByCity(String keyword) {
		
		List<Hospital> hospitals = this.hospitalRepo.searchByCity(keyword);
		
		return hospitals;
		
	}
	

}
