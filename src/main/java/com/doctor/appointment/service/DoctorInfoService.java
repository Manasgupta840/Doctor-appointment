package com.doctor.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.appointment.exceptions.ResourceNotFoundException;
import com.doctor.appointment.models.DoctorInfo;
import com.doctor.appointment.models.DoctorInfo;
import com.doctor.appointment.models.User;
import com.doctor.appointment.repository.DoctorInfoRepo;
import com.doctor.appointment.repository.UserRepo;

@Service
public class DoctorInfoService {
	
	@Autowired
	private DoctorInfoRepo doctorInfoRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public DoctorInfo createDoctorInfo(DoctorInfo doctorInfo, Integer doctorId) {
		User doctor = this.userRepo.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("User","User id", doctorId)); 		
		doctorInfo.setUser(doctor);
		
		DoctorInfo newinfo = this.doctorInfoRepo.save(doctorInfo);
		
		return newinfo;
	}
	
	public DoctorInfo updateDoctorInfo(DoctorInfo doctorInfo , Integer doctorInfoId) {
		DoctorInfo olddoctorInfo = this.doctorInfoRepo.findById(doctorInfoId).orElseThrow(()-> new ResourceNotFoundException("DoctorInfo","DoctorInfo id", doctorInfoId));
		olddoctorInfo.setDescription(doctorInfo.getDescription());
		olddoctorInfo.setOverallExperience(doctorInfo.getOverallExperience());
		olddoctorInfo.setSundayTime(doctorInfo.getSundayTime());
		olddoctorInfo.setWorkingdaysTime(doctorInfo.getWorkingdaysTime());
		DoctorInfo updateddoctorInfo = this.doctorInfoRepo.save(olddoctorInfo);
		return updateddoctorInfo;
	}
	
	public DoctorInfo getDoctorInfoById(Integer doctorInfoId) {
		DoctorInfo doctorInfo = this.doctorInfoRepo.findById(doctorInfoId).orElseThrow(()-> new ResourceNotFoundException("DoctorInfo","DoctorInfo id", doctorInfoId));
		return doctorInfo;
		
	}
	
	public List<DoctorInfo> getAllDoctorInfo(){
		List<DoctorInfo> doctorInfo  = this.doctorInfoRepo.findAll();
		return doctorInfo;
		
	}
	
	public void deleteDoctorInfo(Integer doctorInfoId) {
		DoctorInfo doctorInfo = this.doctorInfoRepo.findById(doctorInfoId).orElseThrow(()-> new ResourceNotFoundException("DoctorInfo","DoctorInfo id", doctorInfoId));
		
		this.doctorInfoRepo.delete(doctorInfo);
		
	}
	
	public List<DoctorInfo> findByOverallExperience(Integer key) {
		
		List<DoctorInfo> doctorInfos = this.doctorInfoRepo.searchByOverallExperience(key);
		
		return doctorInfos;
	}
}
