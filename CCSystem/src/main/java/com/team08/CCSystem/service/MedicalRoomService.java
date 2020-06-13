/**
 * 
 */
package com.team08.CCSystem.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.MedicalRoomDTO;
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
	
	@Autowired
	private HelperService helperService;
	
	
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
			Date endDate = helperService.getDatePlusDuration(startDate, examination.getPrice().getExaminationType().getDuration());
			appointmentsDTO.add(new StartEndDateDTO(startDate, endDate));
		}
		
		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	

	/**
	 * Find all rooms from clinic. Find all examinations in neat time from clinic.
	 * Look from every examination time is overlap with our requested examination time. If does, remove room from clinic room list.
	 * 
	 * Then return list of remain rooms (rooms which are free in requested examination time).
	 * 
	 * @param examinationId
	 * @param clinicId
	 * @return List of rooms
	 */
	public ResponseEntity<List<MedicalRoomDTO>> findFreeRoomsForExaination(Long examinationId, Long clinicId) {
		
		List<MedicalRoom> rooms = new ArrayList<>();
		List<Examination> examinations = new ArrayList<>();
		
		Examination examination = examinationService.findOne(examinationId);
		
		rooms = medicalRoomRepository.findAllByClinicAndInterventionType(clinicId, examination.getPrice().getExaminationType().getInterventionType());
		
		Date startDate;  // start date to search
		Date endDate;  // end date to search
		
		LocalDate dateLocal = examination.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dateLocalStartSearch = dateLocal.minusDays(2);
		LocalDate dateLocalEndSearch = dateLocal.plusDays(2);
		
		startDate = Date.from(dateLocalStartSearch.atStartOfDay(ZoneId.systemDefault()).toInstant());
		endDate = Date.from(dateLocalEndSearch.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		// find all examination in near requested examination time
		examinations = examinationService.findExaminationsBetweenDatesAndClinicIdAndMedicalRoomNull(startDate, endDate, clinicId);
		
		Date startRequestedExaminationDate;  // start requested examination date
		Date endRequestedExaminationDate;  // end requested examination date
		
		startRequestedExaminationDate = examination.getDate();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(startRequestedExaminationDate);
		cal.add(Calendar.MINUTE, examination.getPrice().getExaminationType().getDuration());
		
		endRequestedExaminationDate = helperService.getDatePlusDuration(startRequestedExaminationDate, examination.getPrice().getExaminationType().getDuration());
		
		//------------------------------------
		System.out.println("SOBE KOJE IMAM: ");
		for (MedicalRoom medicalRoom : rooms) {
			System.out.println("     " + medicalRoom.getRoomNumber());
		}
		//------------------------------------
		
		// remove rooms which are taken in requested time
		for (Examination e : examinations) {
			Date startExaminationDate = e.getDate();
			Date endExaminationDate = helperService.getDatePlusDuration(startExaminationDate, e.getPrice().getExaminationType().getDuration());
			boolean isRoomTaken = helperService.areDatesOverlap(startExaminationDate, endExaminationDate, startRequestedExaminationDate, endRequestedExaminationDate);
		
			if (isRoomTaken) {
				//------------------------------------
				System.out.println("UKLANAJM SOBU: " + e.getMedicalRoom().getRoomNumber());
				//------------------------------------
				if (rooms.contains(e.getMedicalRoom())) {
					rooms.remove(e.getMedicalRoom());
				}
			}
		}
		
		// create dto list
		List<MedicalRoomDTO> roomsDTO = new ArrayList<>();
		for (MedicalRoom medicalRoom : rooms) {
			roomsDTO.add(new MedicalRoomDTO(medicalRoom));
		}

		return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
	}

	


}
