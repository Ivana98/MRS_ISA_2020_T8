package com.team08.CCSystem.controler;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.model.User;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserControler {
	private User user;
	private boolean initialized = false;
	
	@GetMapping("/userdata") 
	private User getData() {
		
		if(!initialized) {
			user = new User("123", "user@gmail.com", "Imenko", "Prezimenic", "Street 12", "My City", "Heaven Country", "063132456");
			return user;
		}
		else {
			return user;
		}	
	}
	
	@PostMapping("/savechanges")
	public void create(@RequestBody User user) {
		this.user = user;
	}

}
