/**
 * 
 */
package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicBasicDTO;
import com.team08.CCSystem.dto.ClinicDTO;
import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.dto.ClinicRegistrationDTO;
import com.team08.CCSystem.dto.StartEndDateClinicIdDTO;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.model.ClinicMark;
import com.team08.CCSystem.model.ClinicalCenter;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.Nurse;
import com.team08.CCSystem.service.ClinicService;
import com.team08.CCSystem.service.ClinicalCenterService;

@RestController
@RequestMapping(value = "api/clinics")
public class ClinicControler {
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private ClinicalCenterService clinicalCenterService;
	
	
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
	
	@PostMapping(path = "/save")
	public  ResponseEntity<ClinicRegistrationDTO> save(@RequestBody ClinicRegistrationDTO clinicDTO){

		Address adr = new Address(null,clinicDTO.getStreet(),clinicDTO.getCity(),clinicDTO.getCountry());
		
		ClinicalCenter clinicalCenter = clinicalCenterService.findOne(Long.valueOf(clinicDTO.getClinicalCenter_id()));
		
		Clinic clinic = new Clinic(null,clinicDTO.getName() , adr , clinicalCenter,new HashSet<MedicalRoom>() ,new HashSet<ClinicMark>(),new HashSet<Doctor>(),
				new HashSet<Nurse>(),new HashSet<ClinicAdmin>(),0);
		
		//Ovu liniju mozda staviti u metodu  serivsa.
		clinicalCenter.getClinics().add(clinic);
		
		clinicalCenterService.save(clinicalCenter);
		
		clinicService.save(clinic);
		
		
		return new ResponseEntity<>(clinicDTO , HttpStatus.CREATED);

	}
		
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
	
	@GetMapping(path="/getIncome", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getIncome(@RequestBody StartEndDateClinicIdDTO startEndDateClinicIdDTO) {
		System.out.println("IDEMOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.out.println(startEndDateClinicIdDTO);
		double income = clinicService.getIncome(startEndDateClinicIdDTO);
		
		return new ResponseEntity<>(income, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping("/sendListForTable")  
	public ResponseEntity<List<ClinicForTableDTO>> sendListForTable(){
		
		List<ClinicForTableDTO> clinics = clinicService.convertToClinicForTableDTO();
		return new ResponseEntity<>(clinics, HttpStatus.OK);
	}
	
	@GetMapping(value="/getAverageMark/{id}")
	public ResponseEntity<Float> getAverageMark(@PathVariable Long id) {
		
		return clinicService.getAverageMark(id);
	}
	
}
