package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicForTableDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClinicControler {
	
	@GetMapping("/sendListForTable")  
	private List<ClinicForTableDTO> sendListForTable() {
		List<ClinicForTableDTO> clinics = new ArrayList<ClinicForTableDTO>();
		
		//add dummy data to list
		ClinicForTableDTO cft1 = new ClinicForTableDTO(1, "Hirurgija", "Adresa 1", 4.5);
		ClinicForTableDTO cft2 = new ClinicForTableDTO(2, "Rehabilitacioni centar", "Adresa 2", 4.3);
		ClinicForTableDTO cft3 = new ClinicForTableDTO(3, "Psihijatrija", "Adresa 3", 3.5);
		ClinicForTableDTO cft4 = new ClinicForTableDTO(4, "Porodiliste", "Adresa 4", 2.3);
		ClinicForTableDTO cft5 = new ClinicForTableDTO(4, "Decija bolnica", "Adresa 5", 4.5);
		
		clinics.add(cft1);
		clinics.add(cft2);
		clinics.add(cft3);
		clinics.add(cft4);
		clinics.add(cft5);
		
		return clinics;
	}

}
