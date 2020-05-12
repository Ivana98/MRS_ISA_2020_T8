package com.team08.CCSystem.controler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

import com.team08.CCSystem.dto.LoginDTO;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.model.enums.UserRole;

enum LoginError{
	USER_NOT_EXIST,
	WRONG_PASSWORD,
	OK,
	DATABASE_ERROR
}

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/sessionController")
@RestController
public class SessionController {
	/*
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginToFrontDTO> login(@RequestBody LoginDTO login, HttpServletRequest request, HttpServletResponse response) {
		
		//validation of username
		
		// validation of password
		
		//everything is correct
		//creates new session if it does not exist for current user
		
		LoginToFrontDTO responseDTO = new LoginToFrontDTO();
		User user = this.searchDatabase(login, responseDTO);
		request.getSession().setAttribute("userObject", user);
		request.getSession().setAttribute("userRole", UserRole.PATIENT);
		
		System.out.println(request.getSession().getId());
		System.out.println(request.getSession().getAttribute("userObject"));
		System.out.println(request.getSession().getAttribute("userRole"));
		System.out.println(responseDTO);
		
		return new ResponseEntity<LoginToFrontDTO>(responseDTO, HttpStatus.OK);	
		
	}
	
	private User searchDatabase(LoginDTO login, LoginToFrontDTO error) {
		//does user exist in database
		error.setResponseStatus(LoginError.OK.toString());
		error.setUserRole(UserRole.PATIENT.toString());
		return new Patient();
	}
	*/
	

}
