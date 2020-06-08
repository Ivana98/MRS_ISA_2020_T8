/**
 * 
 */
package com.team08.CCSystem.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.AbsenceDTO;
import com.team08.CCSystem.service.AbsenceService;

/**
 * @author Veljko
 *
 */
@RestController
@RequestMapping(value = "api/absences")
public class AbsenceControler {
	
	@Autowired
	private AbsenceService absenceService;
	
	@PreAuthorize("hasRole('DOCTOR')")
	@PostMapping(path = "/addAbsence")
	public ResponseEntity<AbsenceDTO> addAbsence(@RequestBody AbsenceDTO absenceDTO) {

		return absenceService.addAbsence(absenceDTO);
	}

}
