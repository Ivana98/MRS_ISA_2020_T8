/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.repository.ExaminationRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ExaminationService {
	
	@Autowired
	private ExaminationRepository examinationRepository;
	
	public Examination findOne(Long id) {
		return examinationRepository.findById(id).orElseGet(null);
	}
	
	public List<Examination> findAll() {
		return examinationRepository.findAll();
	}
	
	public Examination save(Examination examination) {
		return examinationRepository.save(examination);
	}
	
	public void remove(Long id) {
		examinationRepository.deleteById(id);
	}

}
