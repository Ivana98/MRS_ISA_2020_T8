package com.team08.CCSystem.dto;

import java.util.Date;
import java.util.Set;

public class ExaminationForPatientDTO {
	private Date dateOfExamination;
	private boolean wasOnExamination;
	private String doctorsName;
	private String examinationType; //Specialisation + InterventionType
	private String clinicName;
	private double price;			//the price at which the examination was paid
	private String description;
	private Set<String> diseases;
	private Set<String> medications; //medication name + description + prescription description
	
	public ExaminationForPatientDTO() {}
	
	public ExaminationForPatientDTO(Date dateOfExamination, boolean wasOnExamination, String doctorsName,
			String examinationType, String clinicName, double price, String description, Set<String> diseases,
			Set<String> medications) {
		super();
		this.dateOfExamination = dateOfExamination;
		this.wasOnExamination = wasOnExamination;
		this.doctorsName = doctorsName;
		this.examinationType = examinationType;
		this.clinicName = clinicName;
		this.price = price;
		this.description = description;
		this.diseases = diseases;
		this.medications = medications;
	}
	
	public Date getDateOfExamination() {
		return dateOfExamination;
	}
	public void setDateOfExamination(Date dateOfExamination) {
		this.dateOfExamination = dateOfExamination;
	}
	public boolean isWasOnExamination() {
		return wasOnExamination;
	}
	public void setWasOnExamination(boolean wasOnExamination) {
		this.wasOnExamination = wasOnExamination;
	}
	public String getDoctorsName() {
		return doctorsName;
	}
	public void setDoctorsName(String doctorsName) {
		this.doctorsName = doctorsName;
	}
	public String getExaminationType() {
		return examinationType;
	}
	public void setExaminationType(String examinationType) {
		this.examinationType = examinationType;
	}
	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getDiseases() {
		return diseases;
	}
	public void setDiseases(Set<String> diseases) {
		this.diseases = diseases;
	}
	public Set<String> getMedications() {
		return medications;
	}
	public void setMedications(Set<String> medications) {
		this.medications = medications;
	}

	

}
