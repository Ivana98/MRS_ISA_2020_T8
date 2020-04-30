/**
 * 
 */
package com.team08.CCSystem.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.MedicalRoomDTO;
import com.team08.CCSystem.service.MedicalRoomService;

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
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<MedicalRoomDTO> saveDoctor(@RequestBody MedicalRoomDTO medicalRoomDTO) {
		System.out.println("Idemo");
		System.out.println(medicalRoomDTO);
		//TODO: Add to database.
		
		return null;
	}

}
