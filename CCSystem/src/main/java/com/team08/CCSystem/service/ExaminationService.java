/**
 * 
 */
package com.team08.CCSystem.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.ApprovedExaminationRequestDTO;
import com.team08.CCSystem.dto.ExaminationRequestDTO;
import com.team08.CCSystem.dto.ExaminationRequestDisplayDTO;
import com.team08.CCSystem.dto.MedicalRecordExaminationDTO;
import com.team08.CCSystem.dto.OfferedAppointmentsDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.model.enums.InterventionType;
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
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private EmailServiceImpl emailService;
	
	@Autowired
	private MedicalRoomService medicalRoomService;
	
	@Autowired
	private HelperService helperService;
	
	@Autowired
	private ClinicService clinicService;
	
	
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

	/**
	 * @param clinicId is is of clinic
	 * @param date i current date from client side
	 * @return
	 */
	public ResponseEntity<List<Integer>> loadDailyExaminations(Long clinicId, Date date) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		List<Integer> examinationsInHour = new ArrayList<>();
		
		// find examinations in last 24 hours, between every hours.
		for (int i = 0; i < 24; i++) {
			Date date1;
			Date date2;
			
			date2 = calendar.getTime();  // 21;
			calendar.add(Calendar.HOUR_OF_DAY, -1);  // 1 hour down
			date1 = calendar.getTime();  // 20h
			examinationsInHour.add(examinationRepository.findExaminationsBetweenDatesAndClinicId(date1, date2, clinicId).size());
		}
		
		return new ResponseEntity<>(examinationsInHour, HttpStatus.OK);
	}

	/**
	 * @param date is current date
	 * @return list of 24 items
	 */
	public ResponseEntity<List<String>> get24HourList(Date date) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		List<String> hours24 = new ArrayList<>();
		
		// list of 24 hours
		for (int i = 0; i < 24; i++) {
			hours24.add(calendar.get(Calendar.HOUR_OF_DAY) + "");
			calendar.add(Calendar.HOUR_OF_DAY, -1);  // 1 hour down
		}
		
		return new ResponseEntity<>(hours24, HttpStatus.OK);
	}

	/**
	 * @param clinicId
	 * @param date
	 * @return
	 */
	public ResponseEntity<List<Integer>> loadWeeklyExaminations(Long clinicId, Date date) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		List<Integer> examinationsInHour = new ArrayList<>();
		
		// find examinations in last 7 days, between every hours.
		for (int i = 0; i < 7; i++) {
			Date date1;
			Date date2;
			
			date2 = calendar.getTime();
			System.out.println(date2);
			calendar.add(Calendar.DATE, -1);  // 1 day down
			date1 = calendar.getTime();
			System.out.println(date1);
			examinationsInHour.add(examinationRepository.findExaminationsBetweenDatesAndClinicId(date1, date2, clinicId).size());
		}
		
		return new ResponseEntity<>(examinationsInHour, HttpStatus.OK);
	}

	/**
	 * @param date
	 * @return
	 */
	public ResponseEntity<List<String>> get7DaysList(Date date) {
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		List<String> days7 = new ArrayList<>();
		
		// list of 7 days
		for (int i = 0; i < 7; i++) {
			days7.add(new SimpleDateFormat("EE").format(calendar.getTime()));
			
			calendar.add(Calendar.DATE, -1);  // 1 hour down
		}
		
		return new ResponseEntity<>(days7, HttpStatus.OK);
	}

	/**
	 * @param clinicId
	 * @param date
	 * @return
	 */
	public ResponseEntity<List<Integer>> loadAnnualExaminations(Long clinicId, Date date) {
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		List<Integer> examinationsInHour = new ArrayList<>();
		
		// find examinations in last 12 months, between every hours.
		for (int i = 0; i < 12; i++) {
			Date date1;
			Date date2;
			
			date2 = calendar.getTime();
			System.out.println(date2);
			calendar.add(Calendar.MONTH, -1);  // 1 month down
			date1 = calendar.getTime();
			System.out.println(date1);
			examinationsInHour.add(examinationRepository.findExaminationsBetweenDatesAndClinicId(date1, date2, clinicId).size());
		}
		
		return new ResponseEntity<>(examinationsInHour, HttpStatus.OK);
	}

	/**
	 * @param date
	 * @return
	 */
	public ResponseEntity<List<String>> get12MonthsList(Date date) {
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		List<String> months12 = new ArrayList<>();
		
		// list of 7 days
		for (int i = 0; i < 7; i++) {
			months12.add(new SimpleDateFormat("MMM").format(calendar.getTime()));
			
			calendar.add(Calendar.DATE, -1);  // 1 hour down
		}
		
		return new ResponseEntity<>(months12, HttpStatus.OK);
	}

	/**
	 * @param dto
	 * @return
	 */
	public ResponseEntity<ExaminationRequestDTO> sendExaminationRequest(ExaminationRequestDTO dto) {
		System.out.println(dto);

		Examination examiantion = new Examination();
		Doctor doctor = doctorService.findOne(dto.getDoctorId());
		Patient patient = patientService.findOne(dto.getPatientId());
		Price price = priceService.findByClinicIdInterventionTypeAndSpecialisation(dto.getClinicId(), InterventionType.valueOf(dto.getInterventionType().toUpperCase()), doctor.getSpecialisation());
		
		examiantion.setDate(dto.getDate());
		examiantion.setDoctor(doctor);
		examiantion.setPatient(patient);
		examiantion.setPrice(price);
		examiantion.setWasOnExamination(false);
		examiantion.setStaticPrice(examiantion.countStaticPrice());
		
		// check if doctor is bussy
		Date startDate = dto.getDate();
		Date endDate = helperService.getDatePlusDuration(startDate, price.getExaminationType().getDuration());
		
		boolean isDoctorBussy = doctorService.isDoctorBussy(startDate, endDate, doctor.getId());
		System.out.println(isDoctorBussy);
		// return null if doctor is bussy
		if (isDoctorBussy) return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		
		save(examiantion);
		
		// send email notification to clinic admin
		emailService.sendMail("mrsisa.t8@gmail.com", "Examination request", "You have one examination request to approve for: \n" + patient);
		
		return new ResponseEntity<>(new ExaminationRequestDTO(examiantion), HttpStatus.CREATED);
	}

	/**
	 * @param clinicId
	 * @return
	 */
	public ResponseEntity<List<ExaminationRequestDisplayDTO>> loadAllExaminationRequest(Long clinicId) {

		List<Examination> examinations = new ArrayList<>();
		
		examinations = examinationRepository.findExaminationRequestFromClinic(clinicId);
		
		// create list of dto
		List<ExaminationRequestDisplayDTO> examinationsDTO = new ArrayList<>();
		for (Examination examination : examinations) {
			System.out.println(new ExaminationRequestDisplayDTO(examination));
			examinationsDTO.add(new ExaminationRequestDisplayDTO(examination));
		}
		
		return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param clinicId
	 * @return
	 */
	public List<Examination> findExaminationsBetweenDatesAndClinicIdAndMedicalRoomNull(Date startDate, Date endDate,
			Long clinicId) {

		return examinationRepository.findExaminationsBetweenDatesAndClinicIdAndMedicalRoomNull(startDate, endDate, clinicId);
	}

	/**
	 * @param dto
	 * @return true if examination request is deleted
	 */
	public ResponseEntity<Boolean> denyExaminationRequest(Long id) {

		Examination examination = findOne(id);
		
		remove(id);
		
		// mail for doctor who requested for examination
		emailService.sendMail("mrsisa.t8@gmail.com", "Examination request", "Request for patient is denied: \n" + examination.getPatient());
		//TODO: obavestiti i pacijenta
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/**
	 * @param dto
	 * @return true for approved examination
	 */
	public ResponseEntity<Boolean> approveExaminationRequest(ApprovedExaminationRequestDTO dto) {
		
		Examination examination = findOne(dto.getId());
		
		if (dto.getNewDate() != null) {
			examination.setDate(dto.getNewDate());
		}

		
		MedicalRoom room = medicalRoomService.findOne(dto.getMedicalRoomId());
		
		examination.setMedicalRoom(room);
		
		save(examination);
		
		// mail for doctor who requested for examination
		emailService.sendMail("mrsisa.t8@gmail.com", "Examination request", "Request for patient is approved: \n" + examination.getPatient());
		emailService.sendMail("mrsisa.t8@gmail.com", "Examination response", "Request for examination is approved. \n");
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	public void converExaminToAppointment(List<OfferedAppointmentsDTO> list, Long clinicId) {
		Date date = new Date(); //this is current date
		//Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		List<Examination> examinations = examinationRepository.findAllFreeFromClinic(clinicId, date);
		for(Examination e : examinations) {
			OfferedAppointmentsDTO dto = new OfferedAppointmentsDTO();
			double price = e.getPrice().getPrice();
			float discount = e.getPrice().getDiscount();
			ExaminationType examinType = e.getPrice().getExaminationType();
			
			dto.setDateOfExamination(e.getDate());
			dto.setDiscount(discount);
			dto.setDoctorsName(e.getDoctor().getName() + " " + e.getDoctor().getSurname());
			dto.setExaminationRoom(e.getMedicalRoom().getRoomNumber());
			dto.setExaminationType(examinType.getSpecialisation().toString() + " " + examinType.getInterventionType().toString());
			dto.setPrice(price - price*discount);
			dto.setDoctorId(e.getDoctor().getId());
			dto.setClinicId(e.getDoctor().getClinic().getId());
			list.add(dto);
		}
	}

	// at 12:00 AM every day
//    @Scheduled(cron="0 0 0 * * ?")
    // at 30 seconds call to see what hapend
//    @Scheduled(cron= "*/5 * * * * *")
	public void findExaminationsAndFreeRooms() {
		
    	List<Clinic> clinics = new ArrayList<Clinic>();
    	clinics = clinicService.findAll();
    	
    	
    	// unazad da bih prvo testirali kliniku 1
    	for (int i = clinics.size() - 1; i >= 0; i--) {
    		// because of some session error
    		try { findExaminationsAndFreeRoomsFromClinic(clinics.get(i)); } catch (Exception e) {}
    	}
    	
	}
	
	/**
	 * @param id
	 */
	private void findExaminationsAndFreeRoomsFromClinic(Clinic clinic) {
		
		List<Examination> requestedExaminations = new ArrayList<Examination>();
		requestedExaminations = examinationRepository.findAllRequestedExaminationsFromClinic(clinic.getId());
		
    	List<MedicalRoom> rooms = medicalRoomService.findAllByClinic(clinic.getId());
    	
    	Random rand = new Random();
    	int rand_int1;
    	
    	List<Examination> allExaminations = new ArrayList<>();
    	
		Date startDateClinicTime = clinic.getTodayStartDateTime();  // start date time of clinic

		//TODO: proveriti i da li je doktor u to vreme slobodan
		for (Examination examination : requestedExaminations) {
			
			// assign random room for requested examination
			rand_int1 = rand.nextInt(rooms.size());
	    	MedicalRoom medicalRoom = rooms.get(rand_int1);
	    	
	    	// find all examinations with chosen room
			allExaminations = examinationRepository.findAllExaminationsFromClinicAndRoomIdAfterDate(clinic.getId(), medicalRoom.getId(), startDateClinicTime);
			
			takeFreeTime(examination, medicalRoom, allExaminations, clinic);
		}
    	
	}

	/**
	 * Prvo proveravamo sve preglede. kada u pregledima nadjemo slobodnu sobu, proveravamo da li je doktor zauzet.
	 * Ako smo dosli do kraja liste pregleda, onda samo trazimo pregled kada je doktor slobodan.
	 * 
	 * @param examination to save with date and medical room
	 * @param medicalRoom
	 * @param allExaminations
	 */
	private void takeFreeTime(Examination examination, MedicalRoom medicalRoom, List<Examination> allExaminations, Clinic clinic) {
		
		Date startExaminationDate;
		Date endExaminationDate;
		
		if (allExaminations.size() == 0) {
			
			startExaminationDate = findDoctorFirstFreeTimeAfterDate(clinic.getTodayStartDateTime());
			
			saveExaminationRoomAndStartDate(startExaminationDate, medicalRoom);
		} else if (allExaminations.size() == 1) {
			Date startClinicDate = clinic.getTodayStartDateTime();
			Date startFirstExaminationDate = allExaminations.get(0).getDate();
			Date endFirstExaminationDate = helperService.getDatePlusDuration(startFirstExaminationDate, allExaminations.get(0).getPrice().getExaminationType().getDuration());                      
			
			startExaminationDate = findDoctorFirstFreeTimeBetweenDates(startClinicDate, startFirstExaminationDate);
			
			if (startExaminationDate == null) {
				startExaminationDate = findDoctorFirstFreeTimeAfterDate(endFirstExaminationDate);
			}
			
			
		} else {
			
			// look between these two dates
			Date date1; Date date2;
			
			date1 = clinic.getTodayStartDateTime();
			
			for (Examination exam : allExaminations) {
				date2 = exam.getDate();
				
				startExaminationDate = findDoctorFirstFreeTimeBetweenDates(date1, date2);
				
				if (startExaminationDate != null) {
					saveExaminationRoomAndStartDate(startExaminationDate, medicalRoom);
					break;
				}
				
				date1 = helperService.getDatePlusDuration(date2, exam.getPrice().getExaminationType().getDuration());
			}
			
			startExaminationDate = findDoctorFirstFreeTimeAfterDate(date1);
			
			saveExaminationRoomAndStartDate(startExaminationDate, medicalRoom);
		}
		
	}

	/**
	 * @param startDate 
	 * @param endDate
	 * @return
	 */
	private Date findDoctorFirstFreeTimeBetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param startExaminationDate
	 * @param medicalRoom
	 */
	private void saveExaminationRoomAndStartDate(Date startExaminationDate, MedicalRoom medicalRoom) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param date
	 * @return
	 */
	private Date findDoctorFirstFreeTimeAfterDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	// every second
    @Scheduled(cron= "*/5 * * * * *")
    public void printEverySecond() {
    	
    }
    
 // every minut
    @Scheduled(cron= "0 * * * * *")
    public void printEveryMinute() {
    	
    }

	/**
	 * @param date
	 * @param doctorId
	 * @return
	 */
	public List<Examination> findAllExaminationsAfterDateAndDoctorId(Date date, Long doctorId) {
		
		return examinationRepository.findAllExaminationsAfterDateAndDoctorId(date, doctorId);
	}

}
