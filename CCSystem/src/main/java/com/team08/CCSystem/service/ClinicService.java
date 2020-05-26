/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.ClinicForTableDTO;
import com.team08.CCSystem.dto.DoctorForClinicListDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.repository.ClinicRepository;

/**
 * @author Veljko
 *
 */
@Service
public class ClinicService {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
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

	public List<ClinicForTableDTO> convertToClinicForTableDTO(){
		List<Clinic> listClinics = this.findAll();
		List<ClinicForTableDTO> setClinics = new ArrayList<ClinicForTableDTO>();
		
		if(listClinics.isEmpty()) return setClinics;
		
		for(Clinic cl : listClinics) {
			ClinicForTableDTO dto = new ClinicForTableDTO();
			dto.setId(cl.getId());
			dto.setName(cl.getName());
			dto.setAddressStreet(cl.getAddress().getStreet());
			dto.setAddressCity(cl.getAddress().getCity());
			dto.setAverageMark(cl.getAverageMark());
			if(!cl.getDoctors().isEmpty()) {
				dto.setDoctors(this.convertClinicDoctors(cl));
			}
			else {
				dto.setDoctors(new HashSet<DoctorForClinicListDTO>());
			}
			setClinics.add(dto);
		}
		return setClinics;
	}
	
	public Set<DoctorForClinicListDTO> convertClinicDoctors(Clinic cl){
		Set<DoctorForClinicListDTO> doctorSet = new HashSet<DoctorForClinicListDTO>();
		for(Doctor d : cl.getDoctors()) {
			DoctorForClinicListDTO dto = new DoctorForClinicListDTO();
			dto.setFirstName(d.getName());
			dto.setLastName(d.getSurname());
			dto.setClinic_id(cl.getId());
			dto.setAverageMark(d.getAverageMark());
			dto.setPhone(d.getPhone());
			dto.setSpecialisation(d.getSpecialisation().toString());
			doctorSet.add(dto);
		}
		return doctorSet;
	}
	
	public ResponseEntity<Float> getAverageMark(Long id) {
		
		Clinic clinic = findOne(id);
		if (clinic == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(clinic.getAverageMark(), HttpStatus.OK);
	}
}

