/**
 * 
 */
package com.team08.CCSystem.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.AbsenceDTO;
import com.team08.CCSystem.dto.AbsenceUserDTO;
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
	
	@PreAuthorize("hasRole('CLINIC_ADMIN')")
	@GetMapping(value = "/getAllFromClinic/{clinicId}")
	public ResponseEntity<List<AbsenceUserDTO>> getAllFromClinic(@PathVariable Long clinicId) {
		
		return absenceService.getAllFromClinic(clinicId);
	}
	
	@PreAuthorize("hasRole('CLINIC_ADMIN')")
	@PostMapping(path = "/confirm", produces = "application/json")
	public ResponseEntity<AbsenceUserDTO> confirm(@RequestBody Long id) {

		return absenceService.confirm(id);
	}

}
