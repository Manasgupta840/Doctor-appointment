package com.doctor.appointment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Doctor_Info")
public class DoctorInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Overall_Experience",nullable= false)
	private Integer overallExperience;
	
	@Column
	private String description;
	
	@Column(name="Doctor_Image")
	private String imageName;
	
	@Column(name="Mon_Sat")
	private String workingdaysTime;
	
	@Column(name="Sun")
	private String sundayTime;
	

	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Integer getOverallExperience() {
		return overallExperience;
	}




	public void setOverallExperience(Integer overallExperience) {
		this.overallExperience = overallExperience;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getImageName() {
		return imageName;
	}




	public void setImageName(String imageName) {
		this.imageName = imageName;
	}




	public String getWorkingdaysTime() {
		return workingdaysTime;
	}




	public void setWorkingdaysTime(String workingdaysTime) {
		this.workingdaysTime = workingdaysTime;
	}




	public String getSundayTime() {
		return sundayTime;
	}




	public void setSundayTime(String sundayTime) {
		this.sundayTime = sundayTime;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public DoctorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@OneToOne
	@MapsId
    @JoinColumn(name = "doctor_id")
    private User user;


}
