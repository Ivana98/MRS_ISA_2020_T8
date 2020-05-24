/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.repository.MedicalRoomRepository;

/**
 * @author Veljko
 *
 */
@Service
public class MedicalRoomService {
	
	@Autowired
	private MedicalRoomRepository medicalRoomRepository;
	
	public MedicalRoom findOne(Long id) {
		return medicalRoomRepository.findById(id).orElseGet(null);
	}
	
	public List<MedicalRoom> findAll() {
		return medicalRoomRepository.findAll();
	}
	
	public MedicalRoom save(MedicalRoom medicalRoom) {
		return medicalRoomRepository.save(medicalRoom);
	}
	
	public void remove(Long id) {
		medicalRoomRepository.deleteById(id);
	}
	
	public List<MedicalRoom> findAllByClinic(Long clinicId) {
		return medicalRoomRepository.findAllByClinic(clinicId);
	}

	public List<MedicalRoom> findAllByClinicAndExamination(Long clinicId, InterventionType it) {
		return medicalRoomRepository.findAllByClinicAndExamination(clinicId, it);
	}

}
