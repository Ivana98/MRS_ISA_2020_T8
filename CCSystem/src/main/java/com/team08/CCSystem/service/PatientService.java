package com.team08.CCSystem.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.MedicalRecordsDTO;
import com.team08.CCSystem.dto.RegistrationRequestDTO;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.ClinicMark;
import com.team08.CCSystem.model.ClinicalCenter;
import com.team08.CCSystem.model.DoctorMark;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.enums.BloodType;
import com.team08.CCSystem.repository.ClinicalCenterRepository;
import com.team08.CCSystem.repository.PatientRepository;

/**
 * @author Veljko
 *
 */
@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ClinicalCenterRepository clinicalCenterRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
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
	
	public Patient addNewPatient(RegistrationRequestDTO request) {
		Patient p = new Patient();
		
		Address address = new Address(null, request.getStreet(), request.getCity(), request.getCountry());
		p.setAddress(address);
		p.setAllergy("");
		p.setBloodType(BloodType.UNKNOWN);
		ClinicalCenter cc = clinicalCenterRepository.findByName("Clinical Center of Vojvodina");
		p.setClinicalCenter(cc);
		p.setClinicsMarks(new HashSet<ClinicMark>());
		p.setDiopter("");
		p.setDoctorsMarks(new HashSet<DoctorMark>());
		p.setEmail(request.getEmail());
		p.setExaminations(new HashSet<Examination>());
		p.setHeight(0);
		p.setName(request.getName());
		p.setPassword(passwordEncoder.encode(request.getPassword()));
		p.setPhone(request.getPhone());
		p.setPolicyholder(request.getPolicyholder());
		p.setSurname(request.getSurname());
		p.setWeight(0);
		
		p.setEnabled(false); //patient is not able to login until use activation link
		
		return patientRepository.save(p);
	}

}
