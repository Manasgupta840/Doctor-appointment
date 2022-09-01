package com.doctor.appointment.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.appointment.exceptions.ResourceNotFoundException;
import com.doctor.appointment.models.Specialization;
import com.doctor.appointment.models.User;
import com.doctor.appointment.repository.SpecializationRepo;
import com.doctor.appointment.repository.UserRepo;

@Service
public class SpecializationService {
	
	@Autowired
	private SpecializationRepo specializationRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public Specialization createSpecialization(Specialization specialization, Integer userId) {
		User doctor = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id", userId)); 
		specialization.setUser(doctor);
		
		Specialization newspecialization =this.specializationRepo.save(specialization);
		
		
		return newspecialization;
	}
	
	public Specialization updateSpecialization(Specialization specialization, Integer specializationId) {
		Specialization oldspecialization =this.specializationRepo.findById(specializationId).orElseThrow(()-> new ResourceNotFoundException("Specialization","Specialization id",specializationId));
		oldspecialization.setDegree(specialization.getDegree());
		oldspecialization.setExperience(specialization.getExperience());
		oldspecialization.setName(specialization.getName());
		Specialization updatedspecialization =this.specializationRepo.save(oldspecialization);
		return updatedspecialization;
	}
	
	public Specialization getSpecializationById(Integer specializationId) {
		Specialization oldspecialization =this.specializationRepo.findById(specializationId).orElseThrow(()-> new ResourceNotFoundException("Specialization","Specialization id",specializationId));
		
		return oldspecialization;
	}
	
	public void deleteSpecialization (Integer specializationId) {
		Specialization specialization=this.specializationRepo.findById(specializationId).orElseThrow(()-> new ResourceNotFoundException("Specialization","Specialization id",specializationId));
		this.specializationRepo.delete(specialization);
	}
	
	public List<Specialization> searchSpecializationByName(String keyword){
		List<Specialization> specializations=this.specializationRepo.searchBySpecializationname(keyword);
		return specializations;
	}
	
	
//	search by keyword
	
	

}