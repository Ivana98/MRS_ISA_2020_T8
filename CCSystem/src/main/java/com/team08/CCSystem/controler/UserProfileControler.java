package com.team08.CCSystem.controler;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.team08.CCSystem.dto.ForAllUsersDTO;
import com.team08.CCSystem.dto.UserPasswordDTO;
import com.team08.CCSystem.dto.UserProfileDTO;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.service.UserService;

import java.security.Principal;

import com.team08.CCSystem.dto.SpecificUserProfileDTO;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.model.ClinicalCenterAdmin;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.Nurse;
import com.team08.CCSystem.model.Patient;


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
	
	@PutMapping(path = "/setUserData", produces = "application/json")
	/*
	 * Ovaj kontroler je samo za menjanje osnovnih podataka koji su atributi u klasi User.
	 * Postojace jos jedan kontroler koji je vezan za sve dodatne atribute koji mogu da se menjanju
	 * kod ostalih tipova korisnika.
	 * 
	 * NAKNADNO OBRISATI OVAJ KOMENTAR
	 */
	public ResponseEntity<UserProfileDTO> setUserData(@RequestBody UserProfileDTO userProfileDTO) {

		User user = userService.findOne(userProfileDTO.getId());
		
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		user.setName(userProfileDTO.getName());
		user.setSurname(userProfileDTO.getSurname());
		Address address = new Address();
		address.setCity(userProfileDTO.getCity());
		address.setCountry(userProfileDTO.getCountry());
		address.setStreet(userProfileDTO.getStreet());
		user.setAddress(address);
		user.setEmail(userProfileDTO.getEmail());
		user.setPassword(userProfileDTO.getPassword());
		user.setPhone(userProfileDTO.getPhone());
		
		user = userService.save(user);
		return new ResponseEntity<>(new UserProfileDTO(user), HttpStatus.OK);
	}
	
	@PutMapping(path = "/updateSpecUser", produces = "application/json")
	public ResponseEntity<SpecificUserProfileDTO> UpdateSpecUser(@RequestBody SpecificUserProfileDTO specificUserProfileDTO) {
		
		User user = userService.findOne(specificUserProfileDTO.getId());
		
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		//TODO: See is this okay when login will be finished.
		// set attributes of inherited classes
		if (user instanceof ClinicAdmin) {
			System.out.println("U pitanju je: " + "ClinicAdmin");
			//TODO:

//			user = userService.save(user);
//			return new ResponseEntity<>(new UserProfileDTO(user), HttpStatus.OK);
		} else if (user instanceof ClinicalCenterAdmin) {
			System.out.println("U pitanju je: " + "ClinicalCenterAdmin");
			//TODO:
//			return new ResponseEntity<>(new DTO(user), HttpStatus.OK);
		} else if (user instanceof Doctor) {
			System.out.println("U pitanju je: " + "Doctor");
			//TODO:
//			return new ResponseEntity<>(new DTO(user), HttpStatus.OK);
		} else if (user instanceof Patient) {
			System.out.println("U pitanju je: " + "Patient");
			//TODO:
//			return new ResponseEntity<>(new DTO(user), HttpStatus.OK);
		} else if (user instanceof Nurse) {
			System.out.println("U pitanju je: " + "Nurse");
			//TODO:
//			return new ResponseEntity<>(new DTO(user), HttpStatus.OK);
		} else {
			System.out.println("Something wrong is happening");
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return null;
	}
	
	@PutMapping(path ="/setUserPassword", consumes = "application/json")
	public ResponseEntity<UserProfileDTO> setUserPassword(@RequestBody UserPasswordDTO userPasswordDTO) {
		//TODO:here should be server validation before writing user in database
		
		
		User user = userService.findOne(userPasswordDTO.getId());
		
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		user.setPassword(userPasswordDTO.getNewPassword());
		
		user = userService.save(user);
		return new ResponseEntity<>(new UserProfileDTO(user), HttpStatus.OK);
		
//		return null;
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
