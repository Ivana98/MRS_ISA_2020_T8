package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.repository.ClinicAdminRepository;

@Service
public class ClinicAdminService {
	
	@Autowired
	private ClinicAdminRepository clinicAdminRepository;
	
	public ClinicAdmin findOne(Long id) {
		return clinicAdminRepository.findById(id).orElseGet(null);
	}
	
	public List<ClinicAdmin> findAll() {
		return clinicAdminRepository.findAll();
	}
	
	public ClinicAdmin save(ClinicAdmin clinicAdmin) {
		return clinicAdminRepository.save(clinicAdmin);
	}
	
	public void remove(Long id) {
		clinicAdminRepository.deleteById(id);
	}
	
}
