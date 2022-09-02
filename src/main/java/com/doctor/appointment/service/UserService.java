package com.doctor.appointment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctor.appointment.exceptions.ResourceNotFoundException;
import com.doctor.appointment.models.User;
import com.doctor.appointment.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User createCustomer(User user) {
		User addedUser = this.userRepo.save(user);
		return addedUser;
	}

	public User updateCustomer(User user, Integer userId) {
		
		User customer = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		customer.setName(user.getName());
		customer.setEmail(user.getEmail());
		customer.setMobileno(user.getMobileno());
		customer.setPassword(this.passwordEncoder.encode(user.getPassword()));
		customer.setType(user.getType());
		
		
		User updatedCustomer = this.userRepo.save(customer);
		
		return updatedCustomer;
	}


	public User getCustomerById(Integer userId) {
		
		User customer = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Customer","Id",userId));
		return customer;
	}

	public List<User> getAllCustomers() {
		
		List<User> customers  = this.userRepo.findAll();	    
	    return customers;
		
	}

	public void deleteCustomer(Integer userId) {
		
		User customer = this.userRepo.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("Customer","Id",userId));
		
		this.userRepo.delete(customer);
	}
	
	public User registerNewCustomer(User user) {
		System.out.println(user.getPassword());
		System.out.println(user.getName());

		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());

		User newCustomer = this.userRepo.save(user);

		return newCustomer ;
	}
}
