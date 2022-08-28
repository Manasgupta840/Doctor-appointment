package com.doctor.appointment.security;

import com.doctor.appointment.models.User;


public class JwtAuthResponse {
	
	private String token;
	
	private User customer;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public JwtAuthResponse(String token, User customer) {
		super();
		this.token = token;
		this.customer = customer;
	}

	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
