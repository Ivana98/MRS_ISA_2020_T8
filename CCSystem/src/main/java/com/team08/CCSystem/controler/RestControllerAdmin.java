package com.team08.CCSystem.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.model.Admin;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestControllerAdmin {
	@Autowired
	private AdminService ads;
			
	@GetMapping("/getAll")
	public List<Admin> getAllAdmin() {
		return ads.getAll();
	}
	
	@PostMapping("/addOne")
	public void addOne(@RequestBody Admin adm) {
		System.out.println("POZVAN");
		System.out.println(adm.getName());
		System.out.println(adm.getPassword());
		ads.save(adm);
	}
}
