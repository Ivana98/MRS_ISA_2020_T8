/**
 * 
 */
package com.team08.CCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.repository.MedicalRoomRepository;

/**
 * @author Veljko
 *
 */
@Service
public class MedicalRoomService {
	
	@Autowired
	private MedicalRoomRepository medicalRoomRepository;
	
	public MedicalRoom save(MedicalRoom medicalRoom) {
		return medicalRoomRepository.save(medicalRoom);
	}

}
