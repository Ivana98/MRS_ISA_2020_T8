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

import com.team08.CCSystem.dto.ExaminationTypeDTO;
import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;
import com.team08.CCSystem.service.ExaminationTypeService;

/**
 * @author Veljko
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/examinationTypes")
public class ExaminationTypeControler {
	
	@Autowired
	private ExaminationTypeService examinationTypeService;
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<ExaminationTypeDTO> saveExeminationType(@RequestBody ExaminationTypeDTO exaTypeDTO) {
		
		InterventionType interventionType = InterventionType.valueOf(exaTypeDTO.getInterventionType().toUpperCase());
		Specialisation specialisation = Specialisation.valueOf(exaTypeDTO.getSpecialisation().toUpperCase());
		
		ExaminationType et = new ExaminationType(exaTypeDTO.getId(), exaTypeDTO.getPrice(), countDuration(exaTypeDTO.getDuration()), interventionType, specialisation);
		
		et = examinationTypeService.save(et);
		
		return new ResponseEntity<ExaminationTypeDTO>(new ExaminationTypeDTO(et), HttpStatus.CREATED);
	}

	/**
	 * @param duration is string with format "hh:mm"
	 * @return duration in minutes
	 */
	private int countDuration(String duration) {
		int hours = Integer.parseInt(duration.substring(0, 2));
		int minutes = Integer.parseInt(duration.substring(3, 5));
		
		int durationToReturn = hours*60+minutes;
		
		return durationToReturn;
	}

}
