package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.MedicalRecordsDTO;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.repository.PatientRepository;

/**
 * @author Veljko
 *
 */
@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient findOne(Long id) {
		return patientRepository.findById(id).orElseGet(null);
	}
	
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
	
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public void remove(Long id) {
		patientRepository.deleteById(id);
	}
	
	public MedicalRecordsDTO convertToMedicalRecords(Patient p) {
		MedicalRecordsDTO records = new MedicalRecordsDTO();
		
		records.setName(p.getName());
		records.setSurname(p.getSurname());
		records.setPolicyholder(p.getPolicyholder());
		records.setHeight(p.getHeight());
		records.setWeight(p.getWeight());
		records.setBloodType(p.getBloodType().toString());
		records.setAllergies(p.getAllergy());
		records.setDiopter(p.getDiopter());
		
		return records;
	}

}
