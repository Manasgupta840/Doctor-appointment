package com.doctor.appointment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doctor.appointment.exceptions.ResourceNotFoundException;
import com.doctor.appointment.models.User;
import com.doctor.appointment.repository.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService  {
	
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User customer = this.userRepo.findBycontactdetail(username).orElseThrow(()-> new ResourceNotFoundException("User", "contactDetail", username));
		
		return (UserDetails) customer;
	}
}
