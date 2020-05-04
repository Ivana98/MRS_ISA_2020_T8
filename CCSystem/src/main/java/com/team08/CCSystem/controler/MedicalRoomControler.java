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
import com.team08.CCSystem.dto.MedicalRoomDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.service.ClinicService;
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

}
