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

import com.team08.CCSystem.dto.ClinicalCenterAdminRegistrationDTO;
import com.team08.CCSystem.model.Absence;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.ClinicalCenter;
import com.team08.CCSystem.model.ClinicalCenterAdmin;
import com.team08.CCSystem.service.AbsenceService;
import com.team08.CCSystem.service.ClinicalCenterService;
import com.team08.CCSystem.service.ClinicalCentreAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/clinicalCenterAdmin")
public class ClinicalCenterAdminControler {
	

	@Autowired
	private ClinicalCentreAdminService clinicalCentreAdminService;
	
	@Autowired
	private ClinicalCenterService clinicalCenterService;
	
	@Autowired
	private AbsenceService absencesService;
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<ClinicalCenterAdminRegistrationDTO> saveDoctor(@RequestBody ClinicalCenterAdminRegistrationDTO clinicalCenterAdminRegistrationDTO) {
		
		Address address = new Address(null, clinicalCenterAdminRegistrationDTO.getStreet(), clinicalCenterAdminRegistrationDTO.getCity(), clinicalCenterAdminRegistrationDTO.getCountry());
		ClinicalCenter clinicalCenter = clinicalCenterService.findOne(Long.valueOf(clinicalCenterAdminRegistrationDTO.getClinicCenter_id()));
		//List<Absence> absences = absencesService.findAll(); nije gotovo jos.
		Set<Absence> absences = new HashSet<Absence>();
		
		ClinicalCenterAdmin clinicalCenterAdmin = new ClinicalCenterAdmin(clinicalCenterAdminRegistrationDTO.getId(), clinicalCenterAdminRegistrationDTO.getEmail(),
							clinicalCenterAdminRegistrationDTO.getFirstName(), clinicalCenterAdminRegistrationDTO.getLastName(), address,
							clinicalCenterAdminRegistrationDTO.getPhone(), clinicalCenterAdminRegistrationDTO.getPassword(),
							absences,clinicalCenter);
		
		clinicalCenterAdmin = clinicalCentreAdminService.save(clinicalCenterAdmin);
		
		return new ResponseEntity<>(new ClinicalCenterAdminRegistrationDTO(clinicalCenterAdmin), HttpStatus.CREATED);
	}
}
