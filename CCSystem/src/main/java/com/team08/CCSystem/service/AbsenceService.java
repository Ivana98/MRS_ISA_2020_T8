
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.AbsenceDTO;
import com.team08.CCSystem.model.Absence;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.model.enums.AbsenceType;
import com.team08.CCSystem.repository.AbsenceRepository;


/**
 * @author Veljko
 *
 */
@Service
public class AbsenceService {
	
	@Autowired
	private AbsenceRepository absenceRepository;
	
	@Autowired
	private UserService userService;
	
	public Absence findOne(Long id) {
		return absenceRepository.findById(id).orElseGet(null);
	}
	
	public List<Absence> findAll() {
		return absenceRepository.findAll();
	}
	
	public Absence save(Absence absence) {
		return absenceRepository.save(absence);
	}
	
	public void remove(Long id) {
		absenceRepository.deleteById(id);
	}

	/**
	 * Save new absence, which admin should confirm. 
	 * 
	 * @param absenceDTO
	 * @return created absence
	 */
	public ResponseEntity<AbsenceDTO> addAbsence(AbsenceDTO absenceDTO) {
		
		User user = userService.findOne(absenceDTO.getUserId());

		Absence absence = new Absence(null, absenceDTO.getBeginDate(), absenceDTO.getEndDate(), user, AbsenceType.valueOf(absenceDTO.getAbsenceType().toUpperCase())); 
		
		absence = save(absence);
		
		return new ResponseEntity<>(new AbsenceDTO(absence), HttpStatus.CREATED);
	}
}
