/**
 * 
 */
package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.Date;
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

import com.team08.CCSystem.dto.DoctorDTO;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.Examination;
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
	
	@GetMapping(path = "/getAll", produces = "application/json")
	public ResponseEntity<List<DoctorDTO>> getAll() {
		
		List<Doctor> doctors = doctorService.findAll();
		
		//converting doctors to DTOs
		List<DoctorDTO> doctorsDTO = new ArrayList<>();
		for (Doctor d : doctors) {
			doctorsDTO.add(new DoctorDTO(d));
		}
		
		return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
	}
	
	@PutMapping(path = "/modify", produces = "application/json")
	public ResponseEntity<DoctorDTO> modify(@RequestBody DoctorDTO doctorDTO) {
		
		Doctor doctor = doctorService.findOne(doctorDTO.getId());
		
		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		//Update doctor
		doctor.getAddress().setCity(doctorDTO.getCity());
		doctor.getAddress().setCountry(doctorDTO.getCountry());
		doctor.getAddress().setStreet(doctorDTO.getStreet());
		doctor.setName(doctorDTO.getFirstName());
		doctor.setSurname(doctorDTO.getLastName());
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setPhone(doctorDTO.getPhone());
		doctor.setPassword(doctorDTO.getPassword());
		doctor.setSpecialisation(Specialisation.valueOf(doctorDTO.getSpecialisation()));
		
		doctor = doctorService.save(doctor);
		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
		
		boolean hasExamination = false;
		
		Doctor doctor = doctorService.findOne(id);
		
		Date currentDate = new Date();

		for (Examination examination : doctor.getExaminations()) {
			if (examination.getDate().after(currentDate)) {
				//doctor has examination in future so he cannot be deleted. 
				hasExamination = true;
			}
		}
		
		if (doctor != null && !hasExamination) {
			doctorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/getAllByClinic/{clinicId}")
	public ResponseEntity<List<DoctorDTO>> getAllByClinic(@PathVariable Long clinicId) {
		
		List<Doctor> doctors = doctorService.findAllByClinic(clinicId);
		
		List<DoctorDTO> doctorsDTO = new ArrayList<>();
		for (Doctor d : doctors) {
			doctorsDTO.add(new DoctorDTO(d));
		}
		
		return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
	}
	
}
