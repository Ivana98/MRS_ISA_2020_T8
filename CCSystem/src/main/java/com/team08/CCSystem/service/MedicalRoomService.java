/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.StartEndDateDTO;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.repository.MedicalRoomRepository;

/**
 * @author Veljko
 *
 */
@Service
public class MedicalRoomService {
	
	@Autowired
	private MedicalRoomRepository medicalRoomRepository;
	
	@Autowired
	private ExaminationService examinationService;
	
	public MedicalRoom findOne(Long id) {
		return medicalRoomRepository.findById(id).orElseGet(null);
	}
	
	public List<MedicalRoom> findAll() {
		return medicalRoomRepository.findAll();
	}
	
	public MedicalRoom save(MedicalRoom medicalRoom) {
		return medicalRoomRepository.save(medicalRoom);
	}
	
	public void remove(Long id) {
		medicalRoomRepository.deleteById(id);
	}
	
	public List<MedicalRoom> findAllByClinic(Long clinicId) {
		return medicalRoomRepository.findAllByClinic(clinicId);
	}

	public List<MedicalRoom> findAllByClinicAndExamination(Long clinicId, InterventionType it) {
		return medicalRoomRepository.findAllByClinicAndExamination(clinicId, it);
	}
	
	/**
	 * Delete medical room from system, if there is no examinations in future.
	 * 
	 * @param id is medical room id
	 * @return true if room is deleted
	 */
	public ResponseEntity<Boolean> delete(Long id) {
		
		MedicalRoom medicalRoom = findOne(id);
		
		if (medicalRoom == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		
		List<Examination> examinations = examinationService.findExaminationWithRoomIdAndAfterDate(id, new Date());
		System.out.println("Velicina liste: " + examinations.size());
		
		if (examinations.isEmpty() || examinations == null || examinations.size() == 0) {
			// If there isn't examinations in future, delete room.
			remove(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			System.out.println("Usao ovde haha");
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 	Find all appointments (start and end date) from now.
	 * 
	 * @param id is room id
	 * @return list of all room appointments
	 */
	public ResponseEntity<List<StartEndDateDTO>> getAllAppointments(Long id) {
		
		// if there is no medical room with id, return bad request
		if (findOne(id) == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
		List<Examination> examinations = examinationService.findExaminationWithRoomIdAndAfterDate(id, new Date());
		
		List<StartEndDateDTO> appointmentsDTO = new ArrayList<>();

		for (Examination examination : examinations) {
			Date startDate = examination.getDate();
			Date endDate = getDatePlusDuration(startDate, examination.getPrice().getExaminationType().getDuration());
			appointmentsDTO.add(new StartEndDateDTO(startDate, endDate));
		}
		
		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	/**
	 * @param startDate is Date
	 * @param duration is duration of examination in minutes
	 * @return start date plus duration (end date)
	 */
	private Date getDatePlusDuration(Date startDate, int duration) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.MINUTE, duration);
		
		return new Date(cal.getTimeInMillis());
	}

}
