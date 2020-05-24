package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.MedicationDTO;
import com.team08.CCSystem.model.Medication;
import com.team08.CCSystem.service.MedicationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/medications")
public class MedicationControler {

	@Autowired
	private MedicationService medicationService;
	
	
	@GetMapping(path = "getAll")
	public ResponseEntity<List<MedicationDTO>> getMedications() {

		List<Medication> medications = medicationService.findAll();

		// convert courses to DTOs
		List<MedicationDTO> medicationsDTO = new ArrayList<>();
		for (Medication m : medications) {
			medicationsDTO.add(new MedicationDTO(m));
		}

		return new ResponseEntity<>(medicationsDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "getOne/{id}")
	public ResponseEntity<MedicationDTO> getMedication(@PathVariable Long id) {

		Medication medication = medicationService.findOne(id);

		// course must exist
		if (medication == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new MedicationDTO(medication), HttpStatus.OK);
	}
	
	@PostMapping(path = "save" , consumes = "application/json")
	public ResponseEntity<MedicationDTO> saveMedication(@RequestBody MedicationDTO medicationDTO) {

		//Kreiranje leka.
		Medication medication = new Medication(null , medicationDTO.getName() , medicationDTO.getDescription());
		//Upisivanje leka u bazu podataka.
		medicationService.save(medication);
		//Poruka o uspesnom kreiranju leka.
		return new ResponseEntity<>(medicationDTO, HttpStatus.CREATED);
	}

	@PutMapping(path = "update",consumes = "application/json")
	public ResponseEntity<MedicationDTO> updateMedication(@RequestBody MedicationDTO medicationDTO) {

		// a course must exist
		Medication medication = medicationService.findOne(medicationDTO.getId());

		if (medication == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		
		medication.setName(medicationDTO.getName());
		medication.setDescription(medicationDTO.getDescription());
		
		medicationService.save(medication);
		return new ResponseEntity<>(medicationDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {

		Medication medication = medicationService.findOne(id);

		if (medication != null) {
			medicationService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
