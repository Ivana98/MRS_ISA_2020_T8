/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.repository.ExaminationRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ExaminationService {
	
	@Autowired
	private ExaminationRepository examinationRepository;
	
	public Examination findOne(Long id) {
		return examinationRepository.findById(id).orElseGet(null);
	}
	
	public List<Examination> findAll() {
		return examinationRepository.findAll();
	}
	
	public Examination save(Examination examination) {
		return examinationRepository.save(examination);
	}
	
	public void remove(Long id) {
		examinationRepository.deleteById(id);
	}
	
	public List<Examination> findExaminationsBetweenDatesAndDoctorId(Date startDate, Date endDate, Long doctorId) {
		return examinationRepository.findExaminationsBetweenDatesAndDoctorId(startDate, endDate, doctorId);
	}
	
	public List<Examination> findExaminationsBetweenDates(Date startDate, Date endDate, Long roomId) {
		return examinationRepository.findExaminationsBetweenDates(startDate, endDate, roomId);
	}
	
	public List<Examination> findExaminationWithRoomIdAndAfterDate(Long roomId, Date date) {
		return examinationRepository.findExaminationWithRoomIdAndAfterDate(roomId, date);
	}
	
	public List<Examination> findAllFreeFromClinic(Long clinicId, Date date) {
		return examinationRepository.findAllFreeFromClinic(clinicId, date);
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param clinicId
	 * @return
	 */
	public List<Examination> findExaminationsBetweenDatesAndClinicId(Date startDate, Date endDate, Long clinicId) {
		return examinationRepository.findExaminationsBetweenDatesAndClinicId(startDate, endDate, clinicId);
	}

	/**
	 * @param date
	 * @param clinicId
	 * @param priceId
	 * @return
	 */
	public List<Examination> findExaminationsAfterDateAndClinicIdAndPriceId(Date date, Long clinicId, Long priceId) {
		return examinationRepository.findExaminationsAfterDateAndClinicIdAndPriceId(date, clinicId, priceId);
	}

}
