package com.team08.CCSystem.controler;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicAdminRegistrationDTO;
import com.team08.CCSystem.model.Absence;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.service.ClinicAdminService;
import com.team08.CCSystem.service.ClinicService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/clinicAdmin")
public class ClinicAdminControler {
	@Autowired
	private ClinicAdminService clinicAdminService;

	@Autowired
	private ClinicService clinicService;
	
	@PostMapping(path = "/save")
	
	public ResponseEntity<ClinicAdminRegistrationDTO> saveClinicAdmin(@RequestBody ClinicAdminRegistrationDTO clinicAdminRegistrationDTO) {
		
		Address address = new Address(null, clinicAdminRegistrationDTO.getStreet(), clinicAdminRegistrationDTO.getCity(), clinicAdminRegistrationDTO.getCountry());

		Clinic clinic = clinicService.findOne(Long.valueOf(clinicAdminRegistrationDTO.getClinic_id()));
		//List<Absence> absences = absencesService.findAll(); nije gotovo jos....ipak ne treba jer prilikom registracije nije jos uvek imao godisnji odmor ili odsustvo.
		Set<Absence> absences = new HashSet<Absence>();
		
		ClinicAdmin clinicAdminRegistration = new ClinicAdmin(clinicAdminRegistrationDTO.getId(), clinicAdminRegistrationDTO.getEmail(),
										clinicAdminRegistrationDTO.getFirstName(), clinicAdminRegistrationDTO.getLastName(),address,
									clinicAdminRegistrationDTO.getPhone(), clinicAdminRegistrationDTO.getPassword(),absences,clinic);
		
		
		clinicAdminRegistration = clinicAdminService.save(clinicAdminRegistration);
		//return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
		
		return new ResponseEntity<>(new ClinicAdminRegistrationDTO(clinicAdminRegistration),HttpStatus.CREATED);
		//return null;
	}
}
