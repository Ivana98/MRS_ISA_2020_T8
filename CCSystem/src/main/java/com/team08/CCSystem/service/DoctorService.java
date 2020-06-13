/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.DoctorAverageMarkDTO;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.DoctorMark;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.repository.DoctorRepository;

/**
 * @author Veljko
 *
 */
@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	private HelperService helperService;
	
	
	public Doctor findOne(Long id) {
		return doctorRepository.findById(id).orElseGet(null);
	}
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	public Doctor save(Doctor doctor) {
		//TODO: check if already exists with same email address. IPAK NE.
		return doctorRepository.save(doctor);
	}
	
	public void remove(Long id) {
		doctorRepository.deleteById(id);
	}
	
	public List<Doctor> findAllByClinic(Long clinicId) {
		return doctorRepository.findAllByClinic(clinicId);
	}

	/**
	 * @param clinicId is clinic id
	 * @return list of doctors.
	 */
	public List<DoctorAverageMarkDTO> getAllByClinicForAverageMark(Long clinicId) {
		
		List<Doctor> doctors = findAllByClinic(clinicId);
		
		List<DoctorAverageMarkDTO> doctorsDTO = new ArrayList<>();
		
		for (Doctor doctor : doctors) {
			doctorsDTO.add(new DoctorAverageMarkDTO(doctor));
		}
		
		return doctorsDTO;
	}
	
	/*
	 * Function checks if patient was on examination at this doctor and returns true
	 * otherwise returns false, which means patient can not rate certain doctor 
	 */
	public boolean hadExaminationDoctor(Long doctorId, Set<Examination> examinations) {
		for(Examination e : examinations) {
			if(e.getWasOnExamination() == true && e.getDoctor().getId() == doctorId) 
				return true;
		}
		return false;
	}
	
	/*
	 * counts new average mark and update doctor in database
	 * */
	public void updateDoctorAverageMark(Doctor doctor) {
		int numberOfMarks = 0;
		float sum = 0;
		for(DoctorMark m : doctor.getMarks()) {
			sum += m.getMark();
			numberOfMarks++;
		}
		doctor.setAverageMark(sum/numberOfMarks);
		doctorRepository.save(doctor);
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public boolean isDoctorBussy(Date startDate, Date endDate, Long doctorId) {

		List<Examination> examinations = new ArrayList<>();
		examinations = examinationService.findExaminationsBetweenDatesAndDoctorId(startDate, endDate, doctorId);
		
		/*
		 * idem kroz preglede.
		 * za svaki pregled proveravam
		 */
		
		for (Examination examination : examinations) {
			Date startExaminationDate = examination.getDate();
			Date endExaminationDate = helperService.getDatePlusDuration(startExaminationDate, examination.getPrice().getExaminationType().getDuration());
			boolean isRoomTaken = helperService.areDatesOverlap(startExaminationDate, endExaminationDate, startDate, endDate);
		}
		
		
		return false;
	}
	
}
