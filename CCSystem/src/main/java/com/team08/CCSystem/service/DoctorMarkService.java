/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.DoctorMark;
import com.team08.CCSystem.repository.DoctorMarkRepository;

/**
 * @author Veljko
 *
 */
@Service
public class DoctorMarkService {
	
	@Autowired
	private DoctorMarkRepository doctorMarkRepository;
	
	public DoctorMark findOne(Long id) {
		return doctorMarkRepository.findById(id).orElseGet(null);
	}
	
	public List<DoctorMark> findAll() {
		return doctorMarkRepository.findAll();
	}
	
	public DoctorMark save(DoctorMark doctorMark) {
		return doctorMarkRepository.save(doctorMark);
	}
	
	public void remove(Long id) {
		doctorMarkRepository.deleteById(id);
	}

}
