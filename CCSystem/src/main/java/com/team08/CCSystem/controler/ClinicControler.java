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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicBasicDTO;
import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.service.ClinicService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/clinics")
public class ClinicControler {
	
	@Autowired
	private ClinicService clinicService;
	
	/*
	 * Load all clinics into list, convert to DTO and return
	 */
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
