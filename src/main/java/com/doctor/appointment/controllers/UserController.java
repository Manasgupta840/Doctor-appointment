package com.doctor.appointment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.appointment.config.ApiResponse;
import com.doctor.appointment.models.User;
import com.doctor.appointment.service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//POST -create user
		@PostMapping("/")
		public ResponseEntity<User> createCustomer(@Validated @RequestBody User User ){
			
			User createUser = this.userService.registerNewCustomer(User);
			return new ResponseEntity<>(createUser, HttpStatus.CREATED);
		}
		
		
		//PUT -update user
		
		@PutMapping("/{userId}")
		public ResponseEntity<User> updateCustomer(@Validated @RequestBody User User,@PathVariable Integer userId){
			
			User updatedCustomer =	this.userService.updateCustomer(User, userId);
			return ResponseEntity.ok(updatedCustomer);
		}
		
		//Delete - delete user
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("userId") Integer uid){
			this.userService.deleteCustomer(uid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Customer deleted Successfully",true), HttpStatus.OK);
		}
	 
		//Get -user get
		@GetMapping("/")
		public ResponseEntity<List<User>> getAllCustomers(){
			return ResponseEntity.ok(this.userService.getAllCustomers());
		}
		
		//Get -user get
		@GetMapping("/{userId}")
		public ResponseEntity<User> getSingleCustomer(@PathVariable Integer userId){
			return ResponseEntity.ok(this.userService.getCustomerById(userId));
			
		}	

}
