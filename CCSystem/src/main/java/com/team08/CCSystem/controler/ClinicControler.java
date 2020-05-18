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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicBasicDTO;
import com.team08.CCSystem.dto.ClinicDTO;
import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.dto.DoctorDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.service.ClinicService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/clinics")
public class ClinicControler {
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<ClinicBasicDTO>> getAll() {
		List<Clinic> clinics = clinicService.findAll();
		
		// convert list clinics to dto
		List<ClinicBasicDTO> clinicsDTO = new ArrayList<ClinicBasicDTO>();
		for (Clinic c : clinics) {
			clinicsDTO.add(new ClinicBasicDTO(c));
		}
		
		return new ResponseEntity<List<ClinicBasicDTO>>(clinicsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/sendListForTable")  
	private List<ClinicForTableDTO> sendListForTable() {
		List<ClinicForTableDTO> clinics = new ArrayList<ClinicForTableDTO>();
		
		//add dummy data to list
		ClinicForTableDTO cft1 = new ClinicForTableDTO(1, "Hirurgija", "Adresa 1", "Novi Sad", 4.5);
		ClinicForTableDTO cft2 = new ClinicForTableDTO(2, "Rehabilitacioni centar", "Adresa 2", "Novi Sad",4.3);
		ClinicForTableDTO cft3 = new ClinicForTableDTO(3, "Psihijatrija", "Adresa 3", "Beograd", 3.5);
		ClinicForTableDTO cft4 = new ClinicForTableDTO(4, "Porodiliste", "Adresa 4", "Novi Sad", 2.3);
		ClinicForTableDTO cft5 = new ClinicForTableDTO(4, "Decija bolnica", "Adresa 5", "Beograd", 4.5);
		
		clinics.add(cft1);
		clinics.add(cft2);
		clinics.add(cft3);
		clinics.add(cft4);
		clinics.add(cft5);
		
		return clinics;
	}
	
	@GetMapping(value = "/getOne/{id}")
	private ResponseEntity<ClinicDTO> getOne(@PathVariable Long id) {
		
		Clinic clinic = clinicService.findOne(id);
		
		if (clinic == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	@PutMapping(path = "/modify", produces = "application/json")
	public ResponseEntity<ClinicDTO> modify(@RequestBody ClinicDTO clinicDTO) {
		
		Clinic clinic = clinicService.findOne(clinicDTO.getId());
		
		if (clinic == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		clinic.setName(clinicDTO.getName());
		clinic.getAddress().setStreet(clinicDTO.getStreet());
		clinic.getAddress().setCity(clinicDTO.getCity());
		clinic.getAddress().setCountry(clinicDTO.getCountry());
		clinic.setDescription(clinicDTO.getDescription());
		
		clinic = clinicService.save(clinic);
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
}
