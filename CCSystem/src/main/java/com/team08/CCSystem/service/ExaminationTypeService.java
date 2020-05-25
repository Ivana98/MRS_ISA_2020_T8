/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.repository.ExaminationTypeRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ExaminationTypeService {
	
	@Autowired
	private ExaminationTypeRepository examinationTypeRepository;
	
	public ExaminationType findOne(Long id) {
		return examinationTypeRepository.findById(id).orElseGet(null);
	}
	
	public List<ExaminationType> findAll() {
		return examinationTypeRepository.findAll();
	}
	
	public ExaminationType save(ExaminationType examinationType) {
		return examinationTypeRepository.save(examinationType);
	}
	
	public void remove(Long id) {
		examinationTypeRepository.deleteById(id);
	}
	
}
