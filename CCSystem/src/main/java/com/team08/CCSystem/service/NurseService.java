/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Nurse;
import com.team08.CCSystem.repository.NurseRepository;

/**
 * @author Veljko
 *
 */
@Service
public class NurseService {
	
	@Autowired
	private NurseRepository nurseRepository;
	
	public Nurse findOne(Long id) {
		return nurseRepository.findById(id).orElseGet(null);
	}
	
	public List<Nurse> findAll() {
		return nurseRepository.findAll();
	}
	
	public Nurse save(Nurse nurse) {
		return nurseRepository.save(nurse);
	}
	
	public void remove(Long id) {
		nurseRepository.deleteById(id);
	}

}
