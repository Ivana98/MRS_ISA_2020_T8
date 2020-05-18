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
import com.team08.CCSystem.dto.MedicalRoomDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.service.ClinicService;
import com.team08.CCSystem.service.ExaminationService;
import com.team08.CCSystem.service.MedicalRoomService;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Inversion;

/**
 * @author Veljko
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/rooms")
public class MedicalRoomControler {
	
	@Autowired
	private MedicalRoomService medicalRoomService;
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private ExaminationService examinationService;
	
	
	@PostMapping(path = "/save")
	public ResponseEntity<MedicalRoomDTO> saveDoctor(@RequestBody MedicalRoomDTO medicalRoomDTO) {
		
		System.out.println(medicalRoomDTO);
		
		Clinic clinic = clinicService.findOne(Long.valueOf(medicalRoomDTO.getClinic_id()));
		InterventionType it = InterventionType.valueOf(medicalRoomDTO.getintervention_type().toUpperCase());
		
		MedicalRoom mRoom = new MedicalRoom(medicalRoomDTO.getId(), medicalRoomDTO.getroom_number(), it, clinic);
		System.out.println(mRoom);
		
		mRoom = medicalRoomService.save(mRoom);
		
		return new ResponseEntity<>(new MedicalRoomDTO(mRoom), HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAll/{clinicId}")
	public ResponseEntity<List<MedicalRoomDTO>> getAll(@PathVariable Long clinicId) {
		
		System.out.println(clinicId);
		List<MedicalRoom> rooms = medicalRoomService.findAllByClinic(clinicId);
		
		List<MedicalRoomDTO> roomsDTO = new ArrayList<>();
		for (MedicalRoom mr : rooms) {
			roomsDTO.add(new MedicalRoomDTO(mr));	
		}
		
		return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllByExamination/{clinicId}")
	public ResponseEntity<List<MedicalRoomDTO>> getAllByExamination(@PathVariable Long clinicId) {
		
		List<MedicalRoom> rooms = medicalRoomService.findAllByClinicAndExamination(clinicId, InterventionType.EXAMINATION);
		
		List<MedicalRoomDTO> roomsDTO = new ArrayList<>();
		for (MedicalRoom mr : rooms) {
			roomsDTO.add(new MedicalRoomDTO(mr));	
		}
		
		return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
	}
	
	@PutMapping(path = "/modify", produces = "application/json")
	public ResponseEntity<MedicalRoomDTO> modify(@RequestBody MedicalRoomDTO medicalRoomDTO) {
		
		MedicalRoom medicalRoom = medicalRoomService.findOne(medicalRoomDTO.getId());
		
		if (medicalRoom == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		medicalRoom.setIntervensionType(InterventionType.valueOf(medicalRoomDTO.getintervention_type().toUpperCase()));
		medicalRoom.setRoomNumber(medicalRoomDTO.getroom_number());
		
		medicalRoom = medicalRoomService.save(medicalRoom);
		return new ResponseEntity<>(new MedicalRoomDTO(medicalRoom), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> deleteMedicalRoom(@PathVariable Long id) {
		
		MedicalRoom medicalRoom = medicalRoomService.findOne(id);
		
		if (medicalRoom == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		List<Examination> examinations = examinationService.findExaminationWithRoomIdAndAfterDate(id, new Date());
		
		if (examinations.isEmpty() || examinations == null || examinations.size() == 0) {
			medicalRoomService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/getOne/{id}")
	public ResponseEntity<MedicalRoomDTO> getOne(@PathVariable Long id) {
		
		MedicalRoom medicalRoom = medicalRoomService.findOne(id);
		
		if (medicalRoom == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new MedicalRoomDTO(medicalRoom), HttpStatus.OK);
	}

}
