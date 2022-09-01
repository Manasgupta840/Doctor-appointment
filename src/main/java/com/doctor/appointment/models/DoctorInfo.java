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
	private String overallExperience;
	
	@Column
	private String description;
	
	@Column(name="Doctor_Image")
	private String imageName;
	
	@Column(name="Mon-Fri")
	private String 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public DoctorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@OneToOne
	@MapsId
    @JoinColumn(name = "doctor_id")
    private User user;


}
