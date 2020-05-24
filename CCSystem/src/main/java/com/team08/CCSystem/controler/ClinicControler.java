/**
 * 
 */
package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicBasicDTO;
import com.team08.CCSystem.dto.ClinicDTO;
import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.service.ClinicService;

@RestController
@RequestMapping(value = "api/clinics")
public class ClinicControler {
	
	@Autowired
	private ClinicService clinicService;
	
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
	
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping("/sendListForTable")  
	public Set<ClinicForTableDTO> sendListForTable() {
		Set<ClinicForTableDTO> clinics = clinicService.convertToClinicForTableDTO();
		return clinics;
	}
	
}
