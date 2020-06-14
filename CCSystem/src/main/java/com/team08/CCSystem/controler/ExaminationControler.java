/**
 * 
 */
package com.team08.CCSystem.controler;

import java.security.Principal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.AbsenceRequestDTO;
import com.team08.CCSystem.dto.AbsenceUserDTO;
import com.team08.CCSystem.dto.ApprovedExaminationRequestDTO;
import com.team08.CCSystem.dto.ExaminationDTO;
import com.team08.CCSystem.dto.ExaminationRequestDTO;
import com.team08.CCSystem.dto.ExaminationRequestDisplayDTO;
import com.team08.CCSystem.dto.MedicalRecordExaminationDTO;
import com.team08.CCSystem.dto.OfferedAppointmentsDTO;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;
import com.team08.CCSystem.service.DoctorService;
import com.team08.CCSystem.service.ExaminationService;
import com.team08.CCSystem.service.MedicalRoomService;
import com.team08.CCSystem.service.PriceService;

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
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping(value = "/getAllFreeFromClinic/{clinicId}")
	public ResponseEntity<List<ExaminationDTO>> getAllFreeFromClinic(@PathVariable Long clinicId) {
		
		List<Examination> examinations = examinationService.findAllFreeFromClinic(clinicId, new Date());
		
		List<ExaminationDTO> examinationsDTO = new ArrayList<>();
		
		for (Examination examination : examinations) {
			System.out.println(new ExaminationDTO(examination));
			examinationsDTO.add(new ExaminationDTO(examination)); 
		}
		
		return new ResponseEntity<List<ExaminationDTO>>(examinationsDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/checkIfDoctorCanOpenMedicalRecord/{patientId}/{doctorId}")
	public ResponseEntity<Boolean> checkIfDoctorCanOpenMedicalRecord(@PathVariable Long patientId, @PathVariable Long doctorId) {
		
		return examinationService.checkIfDoctorCanOpenMedicalRecord(patientId, doctorId);
	}
	
	@GetMapping(value = "/loadPatientExaminations/{patientId}")
	public ResponseEntity<List<MedicalRecordExaminationDTO>> loadPatientExaminations(@PathVariable Long patientId) {
		
		return examinationService.loadPatientExaminations(patientId);
	}
	
	@GetMapping(value = "/canDoctorExaminate/{patientId}/{doctorId}")
	public ResponseEntity<Boolean> canDoctorExaminate(@PathVariable Long patientId, @PathVariable Long doctorId) {
		
		return examinationService.canDoctorExaminate(patientId, doctorId);
	}
	
	@GetMapping(value = "/loadDailyExaminations/{clinicId}/{date}")
	public ResponseEntity<List<Integer>> loadDailyExaminations(@PathVariable Long clinicId, @PathVariable Date date) {
		
		return examinationService.loadDailyExaminations(clinicId, date);
	}
	
	
	@GetMapping(value = "/get24HourList/{date}")
	public ResponseEntity<List<String>> get24HourList(@PathVariable Date date) {
		
		return examinationService.get24HourList(date);
	}
	
	@GetMapping(value = "/loadWeeklyExaminations/{clinicId}/{date}")
	public ResponseEntity<List<Integer>> loadWeeklyExaminations(@PathVariable Long clinicId, @PathVariable Date date) {
		
		return examinationService.loadWeeklyExaminations(clinicId, date);
	}
	
	
	@GetMapping(value = "/get7DaysList/{date}")
	public ResponseEntity<List<String>> get7DaysList(@PathVariable Date date) {
		
		return examinationService.get7DaysList(date);
	}
	
	@GetMapping(value = "/loadAnnualExaminations/{clinicId}/{date}")
	public ResponseEntity<List<Integer>> loadAnnualExaminations(@PathVariable Long clinicId, @PathVariable Date date) {
		
		return examinationService.loadAnnualExaminations(clinicId, date);
	}
	
	
	@GetMapping(value = "/get12MonthsList/{date}")
	public ResponseEntity<List<String>> get12MonthsList(@PathVariable Date date) {
		
		return examinationService.get12MonthsList(date);
	}
	
	@PreAuthorize("hasAnyRole('DOCTOR', 'PATIENT')")
	@PostMapping(path = "/sendExaminationRequest")
	public ResponseEntity<ExaminationRequestDTO> sendExaminationRequest(@RequestBody ExaminationRequestDTO dto) {
		
		return examinationService.sendExaminationRequest(dto);
	}
	
	@PreAuthorize("hasRole('CLINIC_ADMIN')")
	@GetMapping(value = "/loadAllExaminationRequest/{clinicId}")
	public ResponseEntity<List<ExaminationRequestDisplayDTO>> loadAllExaminationRequest(@PathVariable Long clinicId) {
		
		return examinationService.loadAllExaminationRequest(clinicId);
	}
	
	@PreAuthorize("hasRole('CLINIC_ADMIN')")
	@PutMapping(path = "/denyExaminationRequest", produces = "application/json")
	public ResponseEntity<Boolean> denyExaminationRequest(@RequestBody Long id) {

		return examinationService.denyExaminationRequest(id); 
	}
	
	@PreAuthorize("hasRole('CLINIC_ADMIN')")
	@PutMapping(path = "/approveExaminationRequest", produces = "application/json")
	public ResponseEntity<Boolean> approveExaminationRequest(@RequestBody ApprovedExaminationRequestDTO dto) {

		return examinationService.approveExaminationRequest(dto);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		Examination examination = examinationService.findOne(id);
		
		if (examination == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		examinationService.remove(id);
		System.out.println(examination.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/saveOneClickExamination")
	public ResponseEntity<ExaminationDTO> saveOneClickExamination(@RequestBody ExaminationDTO examinationDTO) throws ParseException {
		
		System.out.println(examinationDTO); //DELETE THIS
		
		Doctor doctor = doctorService.findOne(examinationDTO.getDoctorId());
		if (doctor == null) return null;
		
		MedicalRoom medicalRoom = medicalRoomService.findOne(examinationDTO.getMedicalRoomId());
		if (medicalRoom == null) return null;
		
		Price priceList = priceService.findOne(examinationDTO.getPriceId());
		if (priceList == null) return null;
		
		LocalDate dateLocal = examinationDTO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		Calendar cal = Calendar.getInstance();
		LocalDate dateLocal1 = dateLocal.minusDays(2);
		Date date1 = Date.from(dateLocal1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate dateLocal2 = dateLocal.plusDays(3);
		Date date2 = Date.from(dateLocal2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<Examination> examsBetweenDatesAndDoctorId = examinationService.findExaminationsBetweenDatesAndDoctorId(date1, date2, examinationDTO.getDoctorId());
		
		//////////////// if medical room is already in use
		cal.setTime(examinationDTO.getDate());
		cal.add(Calendar.MINUTE, priceList.getExaminationType().getDuration());
		Date dateEnd = new Date(cal.getTimeInMillis());
		List<Examination> examsBetweenDatesAndRoomId = examinationService.findExaminationsBetweenDates(examinationDTO.getDate(), dateEnd, examinationDTO.getMedicalRoomId());
		
		for (Examination exam : examsBetweenDatesAndRoomId) {
			if (exam.getMedicalRoom().getId().equals(medicalRoom.getId())) {
				return null;
			}
		}
		//////////////// create new method for this code
		
		Date startDate = examinationDTO.getDate();
		cal.setTime(startDate);
		
		cal.add(Calendar.MINUTE, priceList.getExaminationType().getDuration());
		Date endDate = new Date(cal.getTimeInMillis());
		
		
		if (examsBetweenDatesAndDoctorId.size() == 0) {
			return createExamination(examinationDTO, doctor, medicalRoom, priceList);
			
		} else if (examsBetweenDatesAndDoctorId.size() == 1) {
			Date date1Start = examsBetweenDatesAndDoctorId.get(0).getDate();
			cal.setTime(date1Start);
			
			int duration = examsBetweenDatesAndDoctorId.get(0).getPrice().getExaminationType().getDuration();
			cal.add(Calendar.MINUTE, duration);
			Date date1End = new Date(cal.getTimeInMillis());

			// if okay create object and write to db
			if (date1Start.equals(startDate) || date1End.equals(endDate)) {
				return null;
			}
			
			if ( !((date1Start.after(startDate) && date1Start.before(endDate)) || (date1End.after(startDate) && date1End.before(endDate))) ) {
				return createExamination(examinationDTO, doctor, medicalRoom, priceList);
			}
		} else {
			for (int i = 0; i < examsBetweenDatesAndDoctorId.size()-1; i++) {
				
				Date date1Start = examsBetweenDatesAndDoctorId.get(i).getDate();
				cal.setTime(date1Start);
				cal.add(Calendar.MINUTE, examsBetweenDatesAndDoctorId.get(i).getPrice().getExaminationType().getDuration());
				Date date1End = new Date(cal.getTimeInMillis());
				
				// next examination
				Date date2Start = examsBetweenDatesAndDoctorId.get(i+1).getDate();
				cal.setTime(date2Start);
				cal.add(Calendar.MINUTE, examsBetweenDatesAndDoctorId.get(i+1).getPrice().getExaminationType().getDuration());
				Date date2End = new Date(cal.getTimeInMillis());
				//not needed date2End
				
				if (date1Start.equals(startDate) || date1End.equals(endDate) || date2Start.equals(startDate) || date2End.equals(endDate)) 
					return null;
				
				// if not okay return null
				if ( (date1End.after(startDate) && date1End.before(endDate)) || (date1End.after(startDate) && date2Start.before(endDate)) || (date2Start.after(startDate) && date2Start.before(endDate)) || (date1Start.after(startDate) && date1Start.before(startDate)) || (date2End.after(startDate) & date2End.before(endDate)) )   
					return null;
			}
			//if null is not returned, it's ok and write to db
			return createExamination(examinationDTO, doctor, medicalRoom, priceList);
		}
		
		return null;
	}
	
	public ResponseEntity<ExaminationDTO> createExamination(ExaminationDTO examinationDTO, Doctor doctor, MedicalRoom medicalRoom, Price price) {
		
		Examination examination = new Examination();
		examination.setDate(examinationDTO.getDate());
		examination.setDoctor(doctor);
		examination.setPrice(price);
		examination.setMedicalRoom(medicalRoom);
		examination.setWasOnExamination(false);
		examination.setDescription("");
		examination.setStaticPrice(price.getPrice() * (100-price.getDiscount()) / 100);
		examination = examinationService.save(examination);

		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.CREATED);
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
	
	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping(path = "/offeredAppointments") 
	public ResponseEntity<List<OfferedAppointmentsDTO>> getOfferedAppointments(@RequestBody Long clinicId){
		
		List<OfferedAppointmentsDTO> list = new ArrayList<OfferedAppointmentsDTO>();
		examinationService.converExaminToAppointment(list, clinicId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//request for one click appointment
	@PreAuthorize("hasAnyRole('PATIENT')")
	@PostMapping(path = "/sendOneClickExaminationRequest")
	public ResponseEntity<OfferedAppointmentsDTO> sendOneClickExaminationRequest(Principal user, @RequestBody OfferedAppointmentsDTO dto) {
		return examinationService.sendOneClickExaminationRequest(user, dto);
		 
	}

}
