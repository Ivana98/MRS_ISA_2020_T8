/**
 * 
 */
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

import com.team08.CCSystem.dto.ExaminationTypeDTO;
import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;
import com.team08.CCSystem.service.ExaminationTypeService;
import com.team08.CCSystem.service.PriceService;

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
	
	@Autowired
	private PriceService priceService;
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<ExaminationTypeDTO> saveExeminationType(@RequestBody ExaminationTypeDTO exaTypeDTO) {
		
		InterventionType interventionType = InterventionType.valueOf(exaTypeDTO.getInterventionType().toUpperCase());
		Specialisation specialisation = Specialisation.valueOf(exaTypeDTO.getSpecialisation().toUpperCase());
		
		ExaminationType et = new ExaminationType(exaTypeDTO.getId(), countDuration(exaTypeDTO.getDuration()), interventionType, specialisation);
		
		et = examinationTypeService.save(et);
		
		return new ResponseEntity<ExaminationTypeDTO>(new ExaminationTypeDTO(et), HttpStatus.CREATED);
	}
	
	/*
	 * Ova metoda ne treba da se koristi. sve se nalazi u Price sto mi treba vezano za ExaminatioType
	 */
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<ExaminationTypeDTO>> getAll(@PathVariable Long clinicId) {

		List<ExaminationType> ETs = examinationTypeService.findAll();
		
		//convert ETs to DTO
		List<ExaminationTypeDTO> ETDTOs = new ArrayList<>();
		for (ExaminationType examinationType : ETs) {
			ETDTOs.add(new ExaminationTypeDTO(examinationType));
		}
		
		return new ResponseEntity<>(ETDTOs, HttpStatus.OK);
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
