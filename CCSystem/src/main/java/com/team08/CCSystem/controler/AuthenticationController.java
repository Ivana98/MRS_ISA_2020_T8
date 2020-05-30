package com.team08.CCSystem.controler;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.LoginDTO;
import com.team08.CCSystem.dto.RegistrationRequestDTO;
import com.team08.CCSystem.dto.UserTokenState;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.repository.PatientRepository;
import com.team08.CCSystem.security.TokenUtils;
import com.team08.CCSystem.service.EmailServiceImpl;
import com.team08.CCSystem.service.PatientService;
import com.team08.CCSystem.service.UserService;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private EmailServiceImpl emailService;

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody LoginDTO authenticationRequest,
			HttpServletResponse response) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint for registration of new patient
	@PostMapping("/registerRequest")
	public ResponseEntity<?> registerRequest(@RequestBody RegistrationRequestDTO userRequest) {

		//check if user with requested email exists
		User existUser = this.userService.findByUsername(userRequest.getEmail());
		Map<String, String> result = new HashMap<>();
		
		if (existUser != null) {
			result.put("result", "that email adress is in use");
			return ResponseEntity.badRequest().body(result);
		}
		
		//save new patient and send email to clinic admin
		Patient patient = patientService.addNewPatient(userRequest);
		emailService.sendMail("mrsisa.t8@gmail.com", "Registration request", patient.toString());
		
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

/*
	// U slucaju isteka vazenja JWT tokena, endpoint koji se poziva da se token osvezi
	@PostMapping(value = "/refresh")
	public ResponseEntity<UserTokenState> refreshAuthenticationToken(HttpServletRequest request) {

		String token = tokenUtils.getToken(request);
		String username = this.tokenUtils.getUsernameFromToken(token);
		User user = (User) this.userDetailsService.loadUserByUsername(username);

		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}
*/

}
