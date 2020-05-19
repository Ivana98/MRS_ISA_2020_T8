package com.team08.CCSystem.controler;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import com.team08.CCSystem.dto.ForAllUsersDTO;
import com.team08.CCSystem.dto.UserPasswordDTO;
import com.team08.CCSystem.dto.UserProfileDTO;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.service.UserService;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/users")
@RestController
public class UserProfileControler {
	//dummy user data
	private UserProfileDTO user = new UserProfileDTO((long) 1, "pera@gmail.com", "Pera", "Peric", "Paunova 24", "Beograd", "Srbija", "+381631236544", "pera");
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserData")  
	private UserProfileDTO getUserData() {
		return this.user;
	}
	
	@PostMapping(path = "/setUserData", consumes = "application/json")
	public boolean setUserData(@RequestBody UserProfileDTO user) {
		//here should be server validation before writing user in database
		try {
			this.user = user;
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	@PostMapping(path ="/setUserPassword", consumes = "application/json")
	public boolean setUserPassword(@RequestBody UserPasswordDTO password) {
		//here should be server validation before writing user in database
		try {
			if(password.getPassword().equals(this.user.getPassword()) && 
					password.getNewPassword().equals(password.getConfirmedPassword())) {
				this.user.setPassword(password.getNewPassword());
				return true;
			}
			return false;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	@GetMapping("/returnCurrentUser")
	@PreAuthorize("hasAnyRole('NURSE', 'DOCTOR', 'PATIENT', 'CLINIC_ADMIN', 'CLINIC_CENTER_ADMIN')")
	public ForAllUsersDTO user(Principal user) {
		try {
			User u = this.userService.findByUsername(user.getName());
			return  this.userService.convertUserToDTO(u);
		}
		catch(NullPointerException e) {
			return null;
		}
		
	}

}
