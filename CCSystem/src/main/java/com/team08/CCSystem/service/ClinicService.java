/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.dto.DoctorForClinicListDTO;
import com.team08.CCSystem.dto.FilterClinicsDTO;
import com.team08.CCSystem.dto.StartEndDateClinicIdDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.ClinicMark;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.DoctorMark;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;
import com.team08.CCSystem.repository.ClinicMarkRepository;
import com.team08.CCSystem.repository.ClinicRepository;
import com.team08.CCSystem.repository.DoctorMarkRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ClinicService {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	private ClinicMarkRepository clinicMarkRepository;
	
	@Autowired
	private DoctorMarkRepository doctorMarkRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private HelperService helperService;
	
	@Autowired
	private PriceService priceService;
	
	public Clinic findOne(Long id) {
		return clinicRepository.findById(id).orElseGet(null);
	}
	
	public List<Clinic> findAll() {
		return clinicRepository.findAll();
	}
	
	public Clinic save(Clinic clinic) {
		return clinicRepository.save(clinic);
	}
	
	public void remove(Long id) {
		clinicRepository.deleteById(id);
	}

	/*
	 * Function produces list of ClinicForTableDTO objects
	 * */
	public List<ClinicForTableDTO> convertToClinicForTableDTO(Patient patient){
		List<Clinic> listClinics = this.findAll();
		List<ClinicForTableDTO> setClinics = new ArrayList<ClinicForTableDTO>();
		
		if(listClinics.isEmpty()) return setClinics;
		
		Long patientId = patient.getId();
		Set<Examination> patientsExaminations = patient.getExaminations();
		
		for(Clinic cl : listClinics) {
			ClinicForTableDTO dto = new ClinicForTableDTO();
			
			convertOneClinic(cl, dto, patientId, patientsExaminations, null);
			
			setClinics.add(dto);
		}
		return setClinics;
	}
	
	/*
	 * Helper function which converts one clinic to ClinicForTableDTO
	 * */
	public void convertOneClinic(Clinic cl, ClinicForTableDTO dto, Long patientId, Set<Examination> patientsExaminations, FilterClinicsDTO filter) {
		dto.setId(cl.getId());
		dto.setName(cl.getName());
		dto.setAddressStreet(cl.getAddress().getStreet());
		dto.setAddressCity(cl.getAddress().getCity());
		dto.setAverageMark(cl.getAverageMark());
		if(!cl.getDoctors().isEmpty() && filter == null) {
			//without filtering doctors
			dto.setDoctors(this.convertClinicDoctors(cl, patientId, patientsExaminations));
		}
		else if(!cl.getDoctors().isEmpty() && filter != null) {
			dto.setDoctors(this.convertClinicDoctors(cl, patientId, patientsExaminations, filter));
			if(!dto.getDoctors().isEmpty()) {
				//if clinic has available doctors set examination price attribute
				Price price = priceService.findByClinicIdInterventionTypeAndSpecialisation(cl.getId(), InterventionType.EXAMINATION, Specialisation.valueOf(filter.getSpecialisation()));
				dto.setExaminationPrice(price.getPrice() - (price.getPrice()*price.getDiscount()));
			}
		}
		else {
			dto.setDoctors(new HashSet<DoctorForClinicListDTO>());
		}
		
		ClinicMark mark = clinicMarkRepository.findClinicMarkByIds(cl.getId(), patientId);
		if(mark != null) {
			dto.setGivenMark(mark.getMark());
			dto.setCanRateClinic(true);
		}
		else {
			dto.setGivenMark(0);
			//check if patient had examination in this clinic
			if(hadExaminationClinic(cl.getId(), patientsExaminations)) {
				dto.setCanRateClinic(true);
			}
			else {
				dto.setCanRateClinic(false);
			}
		}
	}
	
	/*
	 * Function for making Set<DoctorForClinicListDTO> of Clinic object
	 * it extracts Doctor objects from Clinic and pack it to set of transferable objects
	 * */
	public Set<DoctorForClinicListDTO> convertClinicDoctors(Clinic cl, Long patientId, Set<Examination> patientsExaminations){
		Set<DoctorForClinicListDTO> doctorSet = new HashSet<DoctorForClinicListDTO>();
		
		for(Doctor d : cl.getDoctors()) {
			DoctorForClinicListDTO dto = new DoctorForClinicListDTO();
			dto.setFirstName(d.getName());
			dto.setLastName(d.getSurname());
			dto.setClinic_id(cl.getId());
			dto.setAverageMark(d.getAverageMark());
			dto.setPhone(d.getPhone());
			dto.setSpecialisation(d.getSpecialisation().toString());
			dto.setDoctorId(d.getId());
			
			DoctorMark mark = doctorMarkRepository.findDoctorMarkByIds(d.getId(), patientId);
			if(mark != null) {
				dto.setGivenMark(mark.getMark());
				dto.setCanRateDoctor(true);
			}
			else {
				dto.setGivenMark(0);
				//check if patient had examination at this doctor
				if(doctorService.hadExaminationDoctor(d.getId(), patientsExaminations)) {
					dto.setCanRateDoctor(true);
				}
				else {
					dto.setCanRateDoctor(false);
				}
			}
			
			doctorSet.add(dto);
		}
		return doctorSet;
	}
	
	/*
	 * Function checks if patient was on examination in certain clinic and returns true
	 * otherwise returns false, which means patient can not rate certain clinic 
	 */
	public boolean hadExaminationClinic(Long clinicId, Set<Examination> examinations) {
		for(Examination e : examinations) {
			if(e.getWasOnExamination() == true && e.getDoctor().getClinic().getId() == clinicId) 
				return true;
		}
		return false;
	}
	
	public ResponseEntity<Float> getAverageMark(Long id) {
		
		Clinic clinic = findOne(id);
		if (clinic == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(clinic.getAverageMark(), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	public double getIncome(StartEndDateClinicIdDTO sedcDTO) {
		
		List<Examination> examinations = examinationService.findExaminationsBetweenDatesAndClinicId(sedcDTO.getStartDate(), sedcDTO.getEndDate(), sedcDTO.getClinicId());
		
		double totalIncome = 0;
		
		for (Examination examination : examinations) {
			totalIncome += examination.getPrice().getPrice();
		}
		
		return totalIncome;
	}
	
	/*
	 * counts new average mark and update clinic in database
	 * */
	public void updateClinicAverageMark(Clinic clinic) {
		int numberOfMarks = 0;
		float sum = 0;
		for(ClinicMark m : clinic.getMarks()) {
			sum += m.getMark();
			numberOfMarks++;
		}
		clinic.setAverageMark(sum/numberOfMarks);
		clinicRepository.save(clinic);
	}
	
	/*
	 * Function produces list of ClinicForTableDTO objects
	 * after filtering by examination type and wanted date of examination
	 * */
	public List<ClinicForTableDTO> convertFilteredClinics(Patient patient, FilterClinicsDTO filter){
		List<Clinic> listClinics = this.findAll();
		List<ClinicForTableDTO> setClinics = new ArrayList<ClinicForTableDTO>();
		
		if(listClinics.isEmpty()) return setClinics;
		
		Long patientId = patient.getId();
		Set<Examination> patientsExaminations = patient.getExaminations();
		
		for(Clinic cl : listClinics) {
			ClinicForTableDTO dto = new ClinicForTableDTO();
			
			convertOneClinic(cl, dto, patientId, patientsExaminations, filter);
			
			setClinics.add(dto);
		}
		return setClinics;
	}
	
	/*
	 * Function for making Set<DoctorForClinicListDTO> of Clinic object
	 * it extracts Doctor objects from Clinic after filtering  and pack it to set of transferable objects
	 * */
	public Set<DoctorForClinicListDTO> convertClinicDoctors(Clinic cl, Long patientId, Set<Examination> patientsExaminations, FilterClinicsDTO filter){
		Set<DoctorForClinicListDTO> doctorSet = new HashSet<DoctorForClinicListDTO>();
		
		for(Doctor d : cl.getDoctors()) {
			if(!d.getSpecialisation().toString().equalsIgnoreCase(filter.getSpecialisation().toString())) {
				//if this doctor does not have searched specialisation, skip it
				continue;
			}
			
			//checks if doctor is available
			Date startDate = filter.getSearchedDate();
			Price price = priceService.findByClinicIdInterventionTypeAndSpecialisation(cl.getId(), InterventionType.EXAMINATION, d.getSpecialisation());
			//looks for current examination type duration and counts end time (date)
			Date endDate = helperService.getDatePlusDuration(startDate, price.getExaminationType().getDuration());
			if(doctorService.isDoctorBussy(startDate, endDate, d.getId())) {
				//if doctor is bussy at that time skip it
				continue;
			}
			
			DoctorForClinicListDTO dto = new DoctorForClinicListDTO();
			dto.setFirstName(d.getName());
			dto.setLastName(d.getSurname());
			dto.setClinic_id(cl.getId());
			dto.setAverageMark(d.getAverageMark());
			dto.setPhone(d.getPhone());
			dto.setSpecialisation(d.getSpecialisation().toString());
			dto.setDoctorId(d.getId());
			
			DoctorMark mark = doctorMarkRepository.findDoctorMarkByIds(d.getId(), patientId);
			if(mark != null) {
				dto.setGivenMark(mark.getMark());
				dto.setCanRateDoctor(true);
			}
			else {
				dto.setGivenMark(0);
				//check if patient had examination at this doctor
				if(doctorService.hadExaminationDoctor(d.getId(), patientsExaminations)) {
					dto.setCanRateDoctor(true);
				}
				else {
					dto.setCanRateDoctor(false);
				}
			}
			
			doctorSet.add(dto);
		}
		return doctorSet;
	}

}

