/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.DoctorAverageMarkDTO;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.repository.DoctorRepository;

/**
 * @author Veljko
 *
 */
@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor findOne(Long id) {
		return doctorRepository.findById(id).orElseGet(null);
	}
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	public Doctor save(Doctor doctor) {
		//TODO: check if already exists with same email address. IPAK NE.
		return doctorRepository.save(doctor);
	}
	
	public void remove(Long id) {
		doctorRepository.deleteById(id);
	}
	
	public List<Doctor> findAllByClinic(Long clinicId) {
		return doctorRepository.findAllByClinic(clinicId);
	}

	/**
	 * @param clinicId is clinic id
	 * @return list of doctors.
	 */
	public List<DoctorAverageMarkDTO> getAllByClinicForAverageMark(Long clinicId) {
		
		List<Doctor> doctors = findAllByClinic(clinicId);
		
		List<DoctorAverageMarkDTO> doctorsDTO = new ArrayList<>();
		
		for (Doctor doctor : doctors) {
			doctorsDTO.add(new DoctorAverageMarkDTO(doctor));
		}
		
		return doctorsDTO;
	}
	
}
