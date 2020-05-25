package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ClinicalCenterAdmin;

import com.team08.CCSystem.repository.ClinicalCenterAdminRepository;

@Service
public class ClinicalCentreAdminService {
	
	@Autowired
	private ClinicalCenterAdminRepository clinicalCenterAdminRepository;
	
	public ClinicalCenterAdmin findOne(Long id) {
		return clinicalCenterAdminRepository.findById(id).orElseGet(null);
	}
	
	public List<ClinicalCenterAdmin> findAll() {
		return clinicalCenterAdminRepository.findAll();
	}
	
	public ClinicalCenterAdmin save(ClinicalCenterAdmin clinicalCentreAdmin) {
		return clinicalCenterAdminRepository.save(clinicalCentreAdmin);
	}
	
	public void remove(Long id) {
		clinicalCenterAdminRepository.deleteById(id);
	}
	
}
