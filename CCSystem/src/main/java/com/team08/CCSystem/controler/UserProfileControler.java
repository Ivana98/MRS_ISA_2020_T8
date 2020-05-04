package com.team08.CCSystem.controler;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.UserPasswordDTO;
import com.team08.CCSystem.dto.UserProfileDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserProfileControler {
	//dummy user data
	private UserProfileDTO user = new UserProfileDTO((long) 1, "pera@gmail.com", "Pera", "Peric", "Paunova 24", "Beograd", "Srbija", "0631236544", "pera");
	
	@GetMapping("/getUserData")  
	private UserProfileDTO sendListForTable() {
		
		return this.user;
	}
	
	@PostMapping("/setUserData")
	public boolean setUserData(@RequestBody UserProfileDTO user) {
		//here should be server validation before writing user in database
		
		this.user = user;
		return true;
	}
	
	@PostMapping("/setUserPassword")
	public boolean setUserPassword(@RequestBody UserPasswordDTO password) {
		//here should be server validation before writing user in database
		
		if(password.getPreviousPassword().equals(this.user.getPassword()) && 
				password.getNewPassword().equals(password.getConfirmedPassword())) {
			this.user.setPassword(password.getNewPassword());
			return true;
		}
		return false;
	}
	
}
