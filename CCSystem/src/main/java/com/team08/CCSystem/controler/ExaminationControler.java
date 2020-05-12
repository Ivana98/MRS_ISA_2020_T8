/**
 * 
 */
package com.team08.CCSystem.controler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ExaminationDTO;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;
import com.team08.CCSystem.service.DoctorService;
import com.team08.CCSystem.service.ExaminationService;
import com.team08.CCSystem.service.MedicalRoomService;

/**
 * @author Veljko
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/examinations")
public class ExaminationControler {
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private MedicalRoomService medicalRoomService;
	
	@PostMapping(path = "/saveOneClickExamination")
	public ResponseEntity<ExaminationDTO> saveOneClickExamination(@RequestBody ExaminationDTO examinationDTO) throws ParseException {
		
		//TODO: PROVERA DA LI JE SOBA SLOBODNA
		
		LocalDate dateLocal = examinationDTO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		Calendar cal = Calendar.getInstance();
		LocalDate dateLocal1 = dateLocal.minusDays(2);
		Date date1 = Date.from(dateLocal1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate dateLocal2 = dateLocal.plusDays(3);
		Date date2 = Date.from(dateLocal2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<Examination> examsBetween48Hours = examinationService.findExaminationsBetweenDates(date1, date2, examinationDTO.getDoctorId());
		
		Date startDate = examinationDTO.getDate();
		cal.setTime(startDate);

		cal.add(Calendar.MINUTE, getDuration(examinationDTO.getDuration()));
		Date endDate = new Date(cal.getTimeInMillis());
		
		Doctor doctor = doctorService.findOne(examinationDTO.getDoctorId());
		if (doctor == null) return null;
		
		MedicalRoom medicalRoom = medicalRoomService.findOne(examinationDTO.getMedicalRoomId());
		if (medicalRoom == null) return null;
		
		if (examsBetween48Hours.size() == 0) {
			
			ExaminationType examinationType = new ExaminationType();
			examinationType.setDuration(Integer.parseInt(examinationDTO.getDuration()));
			examinationType.setInterventionType(InterventionType.valueOf(examinationDTO.getInterventionType().toUpperCase()));
			examinationType.setPrice(examinationDTO.getPrice());
			examinationType.setSpecialisation(Specialisation.valueOf(examinationDTO.getSpecialisation()));
			
			Examination examination = new Examination();
			examination.setDate(examinationDTO.getDate());
			
			examination.setDoctor(doctor);
			examination.setExaminationType(examinationType);
			
			examination.setMedicalRoom(medicalRoom);
			
			examination.setWasOnExamination(false);
			examination.setDescription("");
			examination.setDiscount(0);
			
			examination = examinationService.save(examination);
			return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.CREATED);
			
		} else if (examsBetween48Hours.size() == 1) {
			Date date1Start = examsBetween48Hours.get(0).getDate();
			cal.setTime(date1Start);
			int duration = examsBetween48Hours.get(0).getExaminationType().getDuration();
			cal.add(Calendar.MINUTE, duration);
			Date date1End = new Date(cal.getTimeInMillis());

			// if okay create object and write to db
			if ( !((date1Start.after(startDate) && date1Start.before(endDate)) || (date1End.after(startDate) && date1End.before(endDate))) ) {
				ExaminationType examinationType = new ExaminationType();
				examinationType.setDuration(getDuration(examinationDTO.getDuration()));
				examinationType.setInterventionType(InterventionType.valueOf(examinationDTO.getInterventionType().toUpperCase()));
				examinationType.setPrice(examinationDTO.getPrice());
				examinationType.setSpecialisation(Specialisation.valueOf(examinationDTO.getSpecialisation()));
				
				Examination examination = new Examination();
				examination.setDate(examinationDTO.getDate());
				
				examination.setDoctor(doctor);
				examination.setExaminationType(examinationType);
				
				examination.setMedicalRoom(medicalRoom);
				
				examination.setWasOnExamination(false);
				examination.setDescription("");
				examination.setDiscount(0);
				
				examination = examinationService.save(examination);
				return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.CREATED);
				
			}
		} else {
			for (int i = 0; i < examsBetween48Hours.size()-1; i++) {
				// current examination
				Date date1Start = examsBetween48Hours.get(i).getDate();
				cal.setTime(date1Start);
				cal.add(Calendar.MINUTE, examsBetween48Hours.get(i).getExaminationType().getDuration());
				Date date1End = new Date(cal.getTimeInMillis());
				
				// next examination
				Date date2Start = examsBetween48Hours.get(i).getDate();
				cal.setTime(date1Start);
				cal.add(Calendar.MINUTE, examsBetween48Hours.get(i).getExaminationType().getDuration());
				
				// if okay write create object and write to db
				if (date1End.before(startDate) && date2Start.after(endDate)) {
					ExaminationType examinationType = new ExaminationType();
					examinationType.setDuration(Integer.parseInt(examinationDTO.getDuration()));
					examinationType.setInterventionType(InterventionType.valueOf(examinationDTO.getInterventionType().toUpperCase()));
					examinationType.setPrice(examinationDTO.getPrice());
					examinationType.setSpecialisation(Specialisation.valueOf(examinationDTO.getSpecialisation()));
					
					Examination examination = new Examination();
					examination.setDate(examinationDTO.getDate());
					
					examination.setDoctor(doctor);
					examination.setExaminationType(examinationType);
					
					examination.setMedicalRoom(medicalRoom);
					
					examination.setWasOnExamination(false);
					examination.setDescription("");
					examination.setDiscount(0);
					
					examination = examinationService.save(examination);
					return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.CREATED);
				}
			}
		}
		
		return null;
	}

	/**
	 * @param duration
	 * @return
	 */
	private int getDuration(String duration) {
		int hours = Integer.parseInt(duration.substring(0, 2));
		int minutes = Integer.parseInt(duration.substring(3, 5));
		int durationToReturn = hours * 60 + minutes;
		return durationToReturn;
	}

}
