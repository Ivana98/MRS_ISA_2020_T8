/**
 * 
 */
package com.team08.CCSystem.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.DoctorDTO;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.enums.Specialisation;
import com.team08.CCSystem.service.ClinicService;
import com.team08.CCSystem.service.DoctorService;

/**
 * @author Veljko
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/doctors")
public class DoctorControler {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ClinicService clinicService;
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<DoctorDTO> saveDoctor(@RequestBody DoctorDTO doctorDTO) {
		
		Address address = new Address(null, doctorDTO.getStreet(), doctorDTO.getCity(), doctorDTO.getCountry());
		Clinic clinic = clinicService.findOne(Long.valueOf(doctorDTO.getClinic_id()));
		Specialisation specialisation = Specialisation.valueOf(doctorDTO.getSpecialisation());
		
		Doctor doctor = new Doctor(doctorDTO.getId(), doctorDTO.getEmail(), doctorDTO.getFirstName(), doctorDTO.getLastName(), address, doctorDTO.getPhone(), doctorDTO.getPassword(), clinic, specialisation, 0);
		
		doctor = doctorService.save(doctor);
		
		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
	}
}
