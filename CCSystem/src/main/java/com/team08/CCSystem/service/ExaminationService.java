/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.MedicalRecordExaminationDTO;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.repository.ExaminationRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ExaminationService {
	
	@Autowired
	private ExaminationRepository examinationRepository;
	
	@Autowired
	private PatientService patientService;
	
	
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

	/**
	 * @param patientId
	 * @param doctorId
	 * @return true if doctor did examination in past for patient
	 */
	public ResponseEntity<Boolean> checkIfDoctorCanOpenMedicalRecord(Long patientId, Long doctorId) {

		List<Examination> examinations = examinationRepository.getDoctorPatientExaminations(patientId, doctorId, new Date());
		
		System.out.println(examinations.size());
		
		if (examinations.isEmpty()) {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/**
	 * @param doctorId
	 * @return
	 */
	public ResponseEntity<List<MedicalRecordExaminationDTO>> loadPatientExaminations(Long patientId) {

		List<Examination> examinations = examinationRepository.findExaminationsByPatientId(patientId);
		
		List<MedicalRecordExaminationDTO> examinationsDTO = new ArrayList<>();
		
		for (Examination examination : examinations) {
			examinationsDTO.add(new MedicalRecordExaminationDTO(examination));
		}
		
		return new ResponseEntity<>(examinationsDTO, HttpStatus.OK); 
	}

	/**
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	public ResponseEntity<Boolean> canDoctorExaminate(Long patientId, Long doctorId) {

		Patient patient = patientService.findOne(patientId);
		
		if (patient == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		for (Examination examination : patient.getExaminations()) {
			if (examination.getDoctor().getId() == doctorId) {
				System.out.println("MOZE DA GA PREGLEDA");
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
		}
		
		System.out.println("NE MOZE DA GA PREGLEDA");
		return new ResponseEntity<>(false, HttpStatus.OK);
	}

}
