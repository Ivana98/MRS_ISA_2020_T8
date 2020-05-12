package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Absence;
import com.team08.CCSystem.repository.AbsenceRepository;

@Service
public class AbsenceService {
	@Autowired
	private AbsenceRepository absenceRepository;
	
	public Absence findOne(Long id) {
		return absenceRepository.findById(id).orElseGet(null);
	}
	
	public List<Absence> findAll() {
		return absenceRepository.findAll();
	}
	
	public Absence save(Absence absence) {
		return absenceRepository.save(absence);
	}
	
	public void remove(Long id) {
		absenceRepository.deleteById(id);
	}
}
