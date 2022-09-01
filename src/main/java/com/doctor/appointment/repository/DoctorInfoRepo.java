package com.doctor.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doctor.appointment.models.DoctorInfo;
import com.doctor.appointment.models.Hospital;
import com.doctor.appointment.models.User;


public interface DoctorInfoRepo extends JpaRepository<DoctorInfo, Integer>  {
	
	@Query("select p from DoctorInfo p where p.overallExperience like :key")
	List<DoctorInfo> searchByOverallExperience( @Param("key") Integer experience);

}
