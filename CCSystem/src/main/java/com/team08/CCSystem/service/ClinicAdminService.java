package com.team08.CCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.repository.ClinicAdminRepository;

@Service
public class ClinicAdminService {
	@Autowired
	private ClinicAdminRepository clinicAdminRepository;
	
	public ClinicAdmin save(ClinicAdmin clinicAdmin) {
		
		return clinicAdminRepository.save(clinicAdmin);
	}
}
