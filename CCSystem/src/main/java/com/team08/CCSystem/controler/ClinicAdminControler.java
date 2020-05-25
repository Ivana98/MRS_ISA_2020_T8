package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.team08.CCSystem.dto.ClinicAdminRegistrationDTO;
import com.team08.CCSystem.dto.MedicalRoomDTO;
import com.team08.CCSystem.model.Absence;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.service.ClinicAdminService;
import com.team08.CCSystem.service.ClinicService;
import com.team08.CCSystem.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/clinicAdmins")
public class ClinicAdminControler {
	
	@Autowired
	private ClinicAdminService clinicAdminService;

	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<ClinicAdminRegistrationDTO> saveClinicAdmin(@RequestBody ClinicAdminRegistrationDTO clinicAdminRegistrationDTO) {
		
		Address address = new Address(null, clinicAdminRegistrationDTO.getStreet(), clinicAdminRegistrationDTO.getCity(), clinicAdminRegistrationDTO.getCountry());

		Clinic clinic = clinicService.findOne(Long.valueOf(clinicAdminRegistrationDTO.getClinic_id()));
		Set<Absence> absences = new HashSet<Absence>();
		
		ClinicAdmin clinicAdminRegistration = new ClinicAdmin(clinicAdminRegistrationDTO.getId(), clinicAdminRegistrationDTO.getEmail(),
										clinicAdminRegistrationDTO.getFirstName(), clinicAdminRegistrationDTO.getLastName(),address,
									clinicAdminRegistrationDTO.getPhone(), clinicAdminRegistrationDTO.getPassword(),absences,clinic);
		
		clinic.getAdmins().add(clinicAdminRegistration);
		clinicService.save(clinic);
		
		clinicAdminService.save(clinicAdminRegistration);
		
		return new ResponseEntity<>(clinicAdminRegistrationDTO,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getRoomsFromClinic/{id}", produces = "application/json")
	public ResponseEntity<List<MedicalRoomDTO>> getRoomsFromClinic(@PathVariable Long id) {
		
		ClinicAdmin admin = clinicAdminService.findOne(id);
		
		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<MedicalRoom> rooms = new ArrayList<>();
		
		for (MedicalRoom mr : admin.getClinic().getRooms()) {
			rooms.add(mr);
		}
		
		List<MedicalRoomDTO> roomsDTO = new ArrayList<>();
		for (MedicalRoom medicalRoom : rooms) {
			roomsDTO.add(new MedicalRoomDTO(medicalRoom));
		}
		
		return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
	}
}
