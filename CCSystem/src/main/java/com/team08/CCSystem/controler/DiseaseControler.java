package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.HashSet;
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

import com.team08.CCSystem.dto.DiseaseDTO;
import com.team08.CCSystem.model.Disease;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.service.DiseaseSerivce;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/disease")
public class DiseaseControler {
	@Autowired
	private DiseaseSerivce diseaseService;
	
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<DiseaseDTO>> getDiseases() {

		List<Disease> diseases = diseaseService.findAll();

		
		List<DiseaseDTO> diseasesDTO = new ArrayList<>();
		for (Disease d : diseases) {
			diseasesDTO.add(new DiseaseDTO(d));
		}

		return new ResponseEntity<>(diseasesDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/getOne/{id}")
	public ResponseEntity<DiseaseDTO> getDisease(@PathVariable Long id) {

		Disease disease = diseaseService.findOne(id);

		if (disease == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DiseaseDTO(disease), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save" , consumes = "application/json")
	public ResponseEntity<DiseaseDTO> saveMedication(@RequestBody DiseaseDTO diseaseDTO) {

		//Kreiranje leka.
		Disease disease = new Disease(null , diseaseDTO.getName() , diseaseDTO.getDescription(),new HashSet<Examination>());
		//Upisivanje leka u bazu podataka.
		diseaseService.save(disease);
		//Poruka o uspesnom kreiranju leka.
		return new ResponseEntity<>(diseaseDTO, HttpStatus.CREATED);
	}

	@PutMapping(path = "/update",consumes = "application/json")
	public ResponseEntity<DiseaseDTO> updateMedication(@RequestBody DiseaseDTO diseaseDTO) {

		
		Disease disease = diseaseService.findOne(diseaseDTO.getId());

		if (disease == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		
		disease.setName(diseaseDTO.getName());
		disease.setDescription(diseaseDTO.getDescription());
		disease.setExaminations(diseaseDTO.getExaminations());
		
		diseaseService.save(disease);
		return new ResponseEntity<>(diseaseDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {

		Disease disease = diseaseService.findOne(id);

		if (disease != null) {
			diseaseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
