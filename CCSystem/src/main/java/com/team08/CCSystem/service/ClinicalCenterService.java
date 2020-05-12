package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ClinicalCenter;
import com.team08.CCSystem.repository.ClinicalCenterRepository;
@Service
public class ClinicalCenterService {
	@Autowired
	private ClinicalCenterRepository clinicalCenterRepository;
	
	public ClinicalCenter findOne(Long id) {
		return clinicalCenterRepository.findById(id).orElseGet(null);
	}
	
	public List<ClinicalCenter> findAll() {
		return clinicalCenterRepository.findAll();
	}
	
	public ClinicalCenter save(ClinicalCenter clinicalCenter) {
		return clinicalCenterRepository.save(clinicalCenter);
	}
	
	public void remove(Long id) {
		clinicalCenterRepository.deleteById(id);
	}

}
