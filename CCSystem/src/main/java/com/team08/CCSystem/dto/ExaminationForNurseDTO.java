package com.team08.CCSystem.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.team08.CCSystem.model.Disease;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.Prescription;

public class ExaminationForNurseDTO {

	private Long id;
	private Date date;
	private boolean wasOnExamination;
	private String description;
	private float discount;
	private String examinationType;
	private Set<PrescriptionForNurseDTO> prescriptions = new HashSet<>();
	private Set<DiseaseForNurseDTO> diseases = new HashSet<>();
	//Mislim da ne treba soba u kojoj je operisan jer nije bas toliko relevanto.
	//private MedicalRoom medicalRoom;
	private String doctor_id; //doctor
	private String doctor_name;
	private String doctor_surname;
	private String doctor_email;

	
	public ExaminationForNurseDTO(Examination exm) {
		super();
		this.id = exm.getId();
		this.date = exm.getDate();
		this.wasOnExamination = exm.getWasOnExamination();
		this.description = exm.getDescription();
		this.discount = exm.getDiscount();
		this.examinationType = exm.getPrice().getExaminationType().getSpecialisation().name();
		this.doctor_id = exm.getDoctor().getId() + "";
		this.doctor_name = exm.getDoctor().getName();
		this.doctor_surname = exm.getDoctor().getSurname();
		this.doctor_email = exm.getDoctor().getEmail();
		//this.prescriptions = new PrescriptionForNurseDTO(exm.getPrescriptions());
				//this.diseases = diseases;
		convertPrescription(exm.getPrescriptions());
		convertDisease(exm.getDiseases());
	
	}


	public ExaminationForNurseDTO(Long id, Date date, boolean wasOnExamination, String description, float discount,
			String examinationType, Set<PrescriptionForNurseDTO> prescriptions, Set<DiseaseForNurseDTO> diseases,
			String doctor_id, String doctor_name, String doctor_surname, String doctor_email) {
		super();
		this.id = id;
		this.date = date;
		this.wasOnExamination = wasOnExamination;
		this.description = description;
		this.discount = discount;
		this.examinationType = examinationType;
		this.prescriptions = prescriptions;
		this.diseases = diseases;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_surname = doctor_surname;
		this.doctor_email = doctor_email;
	}
	
	public void convertPrescription(Set<Prescription> pres) {
		for(Prescription pr : pres) {
			PrescriptionForNurseDTO prfn = new PrescriptionForNurseDTO(pr); 
			this.getPrescriptions().add(prfn);
		}
	}
	
	public void convertDisease(Set<Disease> dis) {
		for(Disease d : dis) {
			DiseaseForNurseDTO di = new DiseaseForNurseDTO(d); 
			this.getDiseases().add(di);
		}
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isWasOnExamination() {
		return wasOnExamination;
	}
	public void setWasOnExamination(boolean wasOnExamination) {
		this.wasOnExamination = wasOnExamination;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getExaminationType() {
		return examinationType;
	}
	public void setExaminationType(String examinationType) {
		this.examinationType = examinationType;
	}
	public Set<PrescriptionForNurseDTO> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(Set<PrescriptionForNurseDTO> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public Set<DiseaseForNurseDTO> getDiseases() {
		return diseases;
	}
	public void setDiseases(Set<DiseaseForNurseDTO> diseases) {
		this.diseases = diseases;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_surname() {
		return doctor_surname;
	}
	public void setDoctor_surname(String doctor_surname) {
		this.doctor_surname = doctor_surname;
	}
	public String getDoctor_email() {
		return doctor_email;
	}
	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}
	@Override
	public String toString() {
		return "ExaminationForNurseDTO [id=" + id + ", date=" + date + ", wasOnExamination=" + wasOnExamination
				+ ", description=" + description + ", discount=" + discount + ", examinationType=" + examinationType
				+ ", prescriptions=" + prescriptions + ", diseases=" + diseases + ", doctor_id=" + doctor_id
				+ ", doctor_name=" + doctor_name + ", doctor_surname=" + doctor_surname + ", doctor_email="
				+ doctor_email + "]";
	}
	
	
	

}


