/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ClinicMark;
import com.team08.CCSystem.repository.ClinicMarkRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ClinicMarkService {
	
	@Autowired
	private ClinicMarkRepository clinicMarkRepository;
	
	public ClinicMark findOne(long id) {
		return clinicMarkRepository.findById(id).orElseGet(null);
	}
	
	public List<ClinicMark> findAll() {
		return clinicMarkRepository.findAll();
	}
	
	public ClinicMark save(ClinicMark clinicMark) {
		return clinicMarkRepository.save(clinicMark);
	}
	
	public void remove(Long id) {
		clinicMarkRepository.deleteById(id);
	}

}
