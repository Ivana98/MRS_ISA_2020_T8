package com.team08.CCSystem.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ExaminationForPatientDTO;
import com.team08.CCSystem.dto.MedicalRecordsDTO;
import com.team08.CCSystem.dto.PatienForNursetDTO;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.service.PatientService;
import com.team08.CCSystem.service.UserService;

@RestController
@RequestMapping(value = "api/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalRecordsControler {
	
	@Autowired 
	private PatientService patientService;

	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping("/sendMedicalRecords")  
	public ResponseEntity<MedicalRecordsDTO> sendMedicalRecords(@RequestBody Long id) { 
		try {
			
			Patient p = patientService.findOne(id);
			if(p != null) {
				return new ResponseEntity<>(patientService.convertToMedicalRecords(p), HttpStatus.OK);
			}	
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new MedicalRecordsDTO(), HttpStatus.BAD_REQUEST);
	}
	
}
