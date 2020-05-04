package com.team08.CCSystem.controler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.MedicalRecordsDTO;
import com.team08.CCSystem.model.enums.BloodType;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/patient")
@RestController
public class MedicalRecordsControler {

	@GetMapping("/sendMedicalRecords")  
	private MedicalRecordsDTO sendMedicalRecords() {
		
		// dummy data for patient
		String bt = BloodType.AB_POS.toString();
		MedicalRecordsDTO records = new MedicalRecordsDTO("Pera", "Peric", "123456", 172, 62, bt, "ambrosia", "");
		
		return records;
	}
	
}
