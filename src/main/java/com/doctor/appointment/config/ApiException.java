package com.doctor.appointment.config;

public class ApiException extends RuntimeException {

	public ApiException() {
		super();
	}
	public ApiException(String message) {
		super(message);
	}

}