/**
 * 
 */
package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.PatientDTO;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.service.PatientService;

/**
 * @author Veljko
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/patients")
public class PatientControler {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping(path = "getAll", produces = "application/json")
	public ResponseEntity<List<PatientDTO>> getAll() {
		
		List<Patient> patients = patientService.findAll();
		
		//convert patients to DTO
		List<PatientDTO> patientsDTO = new ArrayList<>();
		for (Patient patient : patients) {
			patientsDTO.add(new PatientDTO(patient));
		}
		
		return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
	}

}
