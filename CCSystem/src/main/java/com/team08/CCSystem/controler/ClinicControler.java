/**
 * 
 */
package com.team08.CCSystem.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.ClinicBasicDTO;
import com.team08.CCSystem.dto.ClinicDTO;
import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.dto.ClinicRegistrationDTO;
import com.team08.CCSystem.dto.FilterClinicsDTO;
import com.team08.CCSystem.dto.OfferedAppointmentsDTO;
import com.team08.CCSystem.dto.SaveMarkDTO;
import com.team08.CCSystem.dto.StartEndDateClinicIdDTO;
import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.model.ClinicMark;
import com.team08.CCSystem.model.ClinicalCenter;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.DoctorMark;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.Nurse;
import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.repository.ClinicMarkRepository;
import com.team08.CCSystem.repository.ClinicRepository;
import com.team08.CCSystem.repository.DoctorMarkRepository;
import com.team08.CCSystem.service.ClinicService;
import com.team08.CCSystem.service.ClinicalCenterService;
import com.team08.CCSystem.service.DoctorService;
import com.team08.CCSystem.service.UserService;

@RestController
@RequestMapping(value = "api/clinics")
public class ClinicControler {
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private ClinicalCenterService clinicalCenterService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClinicMarkRepository clinicMarkRepository;
	
	@Autowired
	private DoctorMarkRepository doctorMarkRepository;
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping(value = "/getOne/{id}")
	private ResponseEntity<ClinicDTO> getOne(@PathVariable Long id) {
		
		Clinic clinic = clinicService.findOne(id);
		
		if (clinic == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	@PutMapping(path = "/modify", produces = "application/json")
	public ResponseEntity<ClinicDTO> modify(@RequestBody ClinicDTO clinicDTO) {
		
		Clinic clinic = clinicService.findOne(clinicDTO.getId());
		
		if (clinic == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		clinic.setName(clinicDTO.getName());
		clinic.getAddress().setStreet(clinicDTO.getStreet());
		clinic.getAddress().setCity(clinicDTO.getCity());
		clinic.getAddress().setCountry(clinicDTO.getCountry());
		clinic.setDescription(clinicDTO.getDescription());
		
		clinic = clinicService.save(clinic);
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public  ResponseEntity<ClinicRegistrationDTO> save(@RequestBody ClinicRegistrationDTO clinicDTO){

		Address adr = new Address(null,clinicDTO.getStreet(),clinicDTO.getCity(),clinicDTO.getCountry());
		
		ClinicalCenter clinicalCenter = clinicalCenterService.findOne(Long.valueOf(clinicDTO.getClinicalCenter_id()));
		
		Clinic clinic = new Clinic(null,clinicDTO.getName() , adr , clinicalCenter,new HashSet<MedicalRoom>() ,new HashSet<ClinicMark>(),new HashSet<Doctor>(),
				new HashSet<Nurse>(),new HashSet<ClinicAdmin>(),0);
		
		//Ovu liniju mozda staviti u metodu  serivsa.
		clinicalCenter.getClinics().add(clinic);
		
		clinicalCenterService.save(clinicalCenter);
		
		clinicService.save(clinic);
		
		
		return new ResponseEntity<>(clinicDTO , HttpStatus.CREATED);

	}
		
	/*
	 * Load all clinics into list, convert to DTO and return
	 */
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<ClinicBasicDTO>> getAll() {
		List<Clinic> clinics = clinicService.findAll();
		
		// convert list clinics to dto
		List<ClinicBasicDTO> clinicsDTO = new ArrayList<ClinicBasicDTO>();
		for (Clinic c : clinics) {
			clinicsDTO.add(new ClinicBasicDTO(c));
		}
		
		return new ResponseEntity<List<ClinicBasicDTO>>(clinicsDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLINIC_ADMIN')")
	@GetMapping(path = "/getIncome/{startDate}/{endDate}/{clinicId}")
	public ResponseEntity<Double> getIncome(@PathVariable Date startDate, @PathVariable Date endDate, @PathVariable Long clinicId) {
		System.out.println(startDate);
		System.out.println(endDate);
		double income = clinicService.getIncome(new StartEndDateClinicIdDTO(startDate, endDate, clinicId));
		
		return new ResponseEntity<>(income, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('PATIENT')")
	@GetMapping("/sendListForTable")  
	public ResponseEntity<List<ClinicForTableDTO>> sendListForTable(Principal user){
		
		//find current user by email, this should be patient
		Patient p = (Patient) this.userService.findByUsername(user.getName());
		List<ClinicForTableDTO> clinics = clinicService.convertToClinicForTableDTO(p);
		return new ResponseEntity<>(clinics, HttpStatus.OK);
	}
	
	@GetMapping(value="/getAverageMark/{id}")
	public ResponseEntity<Float> getAverageMark(@PathVariable Long id) {
		
		return clinicService.getAverageMark(id);
	}
	
	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping(path = "/saveClinicMark")
	public ResponseEntity<ClinicForTableDTO> saveClinicMark(Principal user, @RequestBody SaveMarkDTO saveMarkDTO) {
		
		Patient patient = (Patient) userService.findByUsername(user.getName());
		Float mark = saveMarkDTO.getMark();
		
		//checks if new mark is valid
		if(clinicService.hadExaminationClinic(saveMarkDTO.getId(), patient.getExaminations()) && ( 0 < mark && mark <= 5)) {
			
			Clinic clinic = clinicRepository.getOne(saveMarkDTO.getId());
			
			ClinicMark newMark = clinicMarkRepository.findClinicMarkByIds(clinic.getId(), patient.getId());
			if(newMark != null) {
				newMark.setMark(mark);
				clinicMarkRepository.save(newMark);
			}
			else {
				clinicMarkRepository.save(new ClinicMark(null, mark, patient, clinic));
			}
			
			clinicService.updateClinicAverageMark(clinic);
			
			//convert clinic to transferable object
			ClinicForTableDTO dto = new ClinicForTableDTO();
			clinicService.convertOneClinic(clinic, dto, patient.getId(), patient.getExaminations(), null);
			
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		//if patient can not rate this clinic return error
		return new ResponseEntity<>(new ClinicForTableDTO(), HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping(path = "/saveDoctorMark")
	public ResponseEntity<ClinicForTableDTO> saveDoctorMark(Principal user, @RequestBody SaveMarkDTO saveMarkDTO) {
		
		Patient patient = (Patient) userService.findByUsername(user.getName());
		Float mark = saveMarkDTO.getMark();
		
		//checks if new mark is valid
		if(doctorService.hadExaminationDoctor(saveMarkDTO.getId(), patient.getExaminations()) && ( 0 < mark && mark <= 5)) {
			
			Doctor doctor = doctorService.findOne(saveMarkDTO.getId());
			Clinic clinic = clinicRepository.getOne(doctor.getClinic().getId());
			
			DoctorMark newMark = doctorMarkRepository.findDoctorMarkByIds(doctor.getId(), patient.getId());
			if(newMark != null) {
				newMark.setMark(mark);
				doctorMarkRepository.save(newMark);
			}
			else {
				doctorMarkRepository.save(new DoctorMark(null, mark, doctor, patient));
			}
			
			doctorService.updateDoctorAverageMark(doctor);
			clinicService.save(clinic);
			
			//convert clinic to transferable object
			ClinicForTableDTO dto = new ClinicForTableDTO();
			clinicService.convertOneClinic(clinic, dto, patient.getId(), patient.getExaminations(), null);
			
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		//if patient can not rate this clinic return error
		return new ResponseEntity<>(new ClinicForTableDTO(), HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasRole('PATIENT')")
	@PostMapping(path = "/filterClinics") 
	public ResponseEntity<List<ClinicForTableDTO>> FilterClinics(Principal user, @RequestBody FilterClinicsDTO filterDTO){
		
		//find current user by email, this should be patient
		Patient p = (Patient) this.userService.findByUsername(user.getName());
		//proveriti da li je dr zauzet ako jeste baciti error ako nije isfiltrirati pa konvertovati
		List<ClinicForTableDTO> clinics = clinicService.convertFilteredClinics(p, filterDTO);
		return new ResponseEntity<>(clinics, HttpStatus.OK);
	}
		
}
