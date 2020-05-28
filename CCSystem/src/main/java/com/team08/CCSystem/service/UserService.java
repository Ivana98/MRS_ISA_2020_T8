package com.team08.CCSystem.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.ForAllUsersDTO;
import com.team08.CCSystem.dto.LoginDTO;
import com.team08.CCSystem.dto.UserPasswordDTO;
import com.team08.CCSystem.model.Authority;
import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.model.ClinicalCenterAdmin;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.Nurse;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.repository.ClinicAdminRepository;
import com.team08.CCSystem.repository.ClinicalCenterAdminRepository;
import com.team08.CCSystem.repository.DoctorRepository;
import com.team08.CCSystem.repository.NurseRepository;
import com.team08.CCSystem.repository.PatientRepository;
import com.team08.CCSystem.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	protected final Log LOGGER = LogFactory.getLog(getClass());

	//@Autowired
	//private UserRepository userRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ClinicAdminRepository clinicAdminRepository;
	
	@Autowired
	private ClinicalCenterAdminRepository clinicalCenterRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private NurseRepository nurseRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthorityService authService;
	
	@Autowired
	private UserRepository userRepository;

	// Funkcija koja na osnovu username-a iz baze vraca objekat User-a
	//username je email adresa
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User patient = patientRepository.findByEmail(username);
		if (patient != null) {
			return patient;
		}
		
		User doctor = doctorRepository.findByEmail(username);
		if (doctor != null) {
			return doctor;
		}
		
		User nurse = nurseRepository.findByEmail(username);
		if (nurse != null) {
			return nurse;
		}
		
		User clinicalAdmin = clinicAdminRepository.findByEmail(username);
		if (clinicalAdmin != null) {
			return clinicalAdmin;
		}
		
		User clinicalCenterAdmin = clinicalCenterRepository.findByEmail(username);
		if (clinicalCenterAdmin != null) {
			return clinicalCenterAdmin;
		}
		
		throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		
	}


	// Funkcija pomocu koje korisnik menja svoju lozinku
	public boolean changePassword(UserPasswordDTO userPassword) {

		// Ocitavamo trenutno ulogovanog korisnika
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		String username = currentUser.getName();

		if (authenticationManager != null) {
			LOGGER.debug("Re-authenticating user '" + username + "' for password change request.");

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword.getPassword()));
		} else {
			LOGGER.debug("No authentication manager set. can't change Password!");

			return false;
		}

		LOGGER.debug("Changing password for user '" + username + "'");

		User user = (User) loadUserByUsername(username);

		// pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati
		// ne zelimo da u bazi cuvamo lozinke u plain text formatu
		user.setPassword(passwordEncoder.encode(userPassword.getNewPassword()));
		userRepository.save(user);
		return true;
	}

	
	//user service implementation
	public User findByUsername(String username) {	
		User u;
		
		try {
			if((u = patientRepository.findByEmail(username)) != null)
				return u;
		}
		catch(UsernameNotFoundException e) {}
		
		try {
			if((u = doctorRepository.findByEmail(username)) != null)
				return u;
		}
		catch(UsernameNotFoundException e) {}
		
		try {
			if((u = nurseRepository.findByEmail(username)) != null)
				return u;
		}
		catch(UsernameNotFoundException e) {}
		
		try {
			if((u = clinicAdminRepository.findByEmail(username)) != null)
				return u;
		}
		catch(UsernameNotFoundException e) {}
		
		try {
			if((u = clinicalCenterRepository.findByEmail(username))!= null)
			return u;
		}
		catch(UsernameNotFoundException e) {
			return null;
		}
		return null;
	}
	
	public ForAllUsersDTO convertUserToDTO(User user) {
		ForAllUsersDTO userDTO = new ForAllUsersDTO();
		
		userDTO.setUserId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setSurname(user.getSurname());
		userDTO.setStreet(user.getAddress().getStreet());
		userDTO.setCity(user.getAddress().getCity());
		userDTO.setCountry(user.getAddress().getCountry());
		userDTO.setPhone(user.getPhone());
		
		List<Authority> authority =  (List<Authority>) user.getAuthorities();
		userDTO.setUserAuthority(authority.get(0).getName());
		
		if(user instanceof Patient) {
			userDTO.setPolicyholder(((Patient) user).getPolicyholder());
		}
		else if (user instanceof Doctor){
			userDTO.setClinicId(((Doctor) user).getClinic().getId());
			userDTO.setAverageMark(((Doctor) user).getAverageMark());
			userDTO.setSpecialisation(((Doctor) user).getSpecialisation().toString());
		}
		else if (user instanceof ClinicalCenterAdmin) {
			userDTO.setClinicId(((ClinicalCenterAdmin) user).getClinicalCenter().getId());
		}
		else if (user instanceof ClinicAdmin) {
			userDTO.setClinicId(((ClinicAdmin) user).getClinic().getId());
		}
		else {
			userDTO.setClinicId(((Nurse) user).getClinic().getId());
		}
		
		return userDTO;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = patientRepository.findById(id).orElseGet(null);
		if(u != null) return u;
		
		if((u = doctorRepository.findById(id).orElseGet(null)) != null) return u;
		
		if((u = nurseRepository.findById(id).orElseGet(null)) != null) return u;
		
		if((u = clinicAdminRepository.findById(id).orElseGet(null)) != null) return u;
		
		u = clinicalCenterRepository.findById(id).orElseGet(null);
		return u;	
	}


	
	public User findOne(Long id) {
		return userRepository.findById(id).orElseGet(null);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void remove(Long id) {
		userRepository.deleteById(id);
	}
	
}
