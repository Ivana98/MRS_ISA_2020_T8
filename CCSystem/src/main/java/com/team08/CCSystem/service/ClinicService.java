/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.repository.ClinicRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ClinicService {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	public Clinic findOne(Long id) {
		return clinicRepository.findById(id).orElseGet(null);
	}
	
	public List<Clinic> findAll() {
		return clinicRepository.findAll();
	}
	
	public Clinic save(Clinic clinic) {
		return clinicRepository.save(clinic);
	}
	
	public void remove(Long id) {
		clinicRepository.deleteById(id);
	}

}
