package com.team08.CCSystem.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.MedicalRecordsDTO;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.service.PatientService;
import com.team08.CCSystem.service.UserService;

@RestController
@RequestMapping(value = "api/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalRecordsControler {
	
	@Autowired 
	private PatientService patientS;

	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping("/sendMedicalRecords")  
	public MedicalRecordsDTO sendMedicalRecords(@RequestBody Long id) { 
		try {
			Patient p = patientS.findOne(id);
			if(p != null) {
				return patientS.convertToMedicalRecords(p);
			}	
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
