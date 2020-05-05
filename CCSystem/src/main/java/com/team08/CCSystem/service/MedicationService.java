/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Medication;
import com.team08.CCSystem.repository.MedicationRepository;

/**
 * @author Veljko
 *
 */
@Service
public class MedicationService {
	
	@Autowired
	private MedicationRepository medicationRepository;
	
	public Medication findOne(Long id) {
		return medicationRepository.findById(id).orElseGet(null);
	}
	
	public List<Medication> findAll() {
		return medicationRepository.findAll();
	}
	
	public Medication save(Medication medication) {
		return medicationRepository.save(medication);
	}
	
	public void remove(Long id) {
		medicationRepository.deleteById(id);
	}
 
}
