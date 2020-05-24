package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.DiseaseDTO;
import com.team08.CCSystem.dto.PatienForNursetDTO;
import com.team08.CCSystem.model.Disease;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.service.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/patient")
public class PatientControler {
	@Autowired
	private PatientService patientService;
	
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<PatienForNursetDTO>> getPatients() {

		List<Patient> patients = patientService.findAll();

		// convert courses to DTOs
		List<PatienForNursetDTO> patientsDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientsDTO.add(new PatienForNursetDTO(p));
		}

		return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "getOne/{id}")
	public ResponseEntity<PatienForNursetDTO> getDisease(@PathVariable Long id) {

		Patient pat = patientService.findOne(id);

		// course must exist
		if (pat == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PatienForNursetDTO(pat), HttpStatus.OK);
	}
	
//	@PostMapping(path = "save" , consumes = "application/json")
//	public ResponseEntity<DiseaseDTO> saveMedication(@RequestBody DiseaseDTO diseaseDTO) {
//
//		//Kreiranje leka.
//		Disease disease = new Disease(null , diseaseDTO.getName() , diseaseDTO.getDescription(),new HashSet<Examination>());
//		//Upisivanje leka u bazu podataka.
//		diseaseService.save(disease);
//		//Poruka o uspesnom kreiranju leka.
//		return new ResponseEntity<>(diseaseDTO, HttpStatus.CREATED);
//	}


}
