/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Prescription;
import com.team08.CCSystem.repository.PrescriptionRepository;

/**
 * @author Veljko
 *
 */
@Service
public class PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public Prescription findOne(Long id) {
		return prescriptionRepository.findById(id).orElseGet(null);
	}
	
	public List<Prescription> findAll() {
		return prescriptionRepository.findAll();
	}
	
	public Prescription save(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	public void remove(Long id) {
		prescriptionRepository.deleteById(id);
	}

}
