package com.team08.CCSystem.controler;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.UserProfileDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserProfileControler {
	
	@GetMapping("/getUserData")  
	private UserProfileDTO sendListForTable() {
		
		//dummy user data
		UserProfileDTO user = new UserProfileDTO((long) 1, "pera@gmail.com", "Pera", "Peric", "Paunova 24", "Beograd", "Srbija", "0631236544", "pera");
		
		return user;
	}
	
}
