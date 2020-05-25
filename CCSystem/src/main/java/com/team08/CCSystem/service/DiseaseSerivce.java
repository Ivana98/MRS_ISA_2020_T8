package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Disease;
import com.team08.CCSystem.repository.DiseaseRepository;
@Service
public class DiseaseSerivce {
	@Autowired
	private DiseaseRepository diseaseRepository;
	
	public Disease findOne(Long id) {
		return diseaseRepository.findById(id).orElseGet(null);
	}
	
	public List<Disease> findAll() {
		return diseaseRepository.findAll();
	}
	
	public Disease save(Disease disease) {
		return diseaseRepository.save(disease);
	}
	
	public void remove(Long id) {
		diseaseRepository.deleteById(id);
	}
}
