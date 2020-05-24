package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

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

import com.team08.CCSystem.dto.ClinicAdminDTO;
import com.team08.CCSystem.dto.MedicalRoomDTO;
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
	public ResponseEntity<ClinicAdminDTO> saveClinicAdmin(@RequestBody ClinicAdminDTO clinicAdminDTO) {
		
		System.out.println(clinicAdminDTO);
		
//		Address address = new Address(null, clinicAdminDTO.getStreet(), clinicAdminDTO.getCity(), clinicAdminDTO.getCountry());
//		System.out.println("USAOOOdsadsadsaffffa");
//		System.out.println(clinicAdminDTO.getClinic_id() + "IDDDD");
//		Clinic clinic = clinicService.findOne(Long.valueOf(clinicAdminDTO.getClinic_id()));
//		
//		ClinicAdmin clinicAdmin = new ClinicAdmin(clinicAdminDTO.getId(), clinicAdminDTO.getEmail(), clinicAdminDTO.getFirstName(), clinicAdminDTO.getLastName(), address, clinicAdminDTO.getPhone(), clinicAdminDTO.getPassword(),null,clinic);
//		
//		clinicAdminService.save(clinicAdmin);
		
//		return new ResponseEntity<>(HttpStatus.CREATED);
		return null;
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
//		return null;
	}
}
