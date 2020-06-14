package com.team08.CCSystem.dto;

import java.util.Date;

public class OfferedAppointmentsDTO {
	private Date dateOfExamination; //date and time
    private String examinationRoom;
    public String doctorsName; // name and surname
    public String examinationType; 
    public double price; //with discount
    public float discount;
    public Long doctorId;
    public Long clinicId;
    public Long examinationId;
    public Long patientId;
    
    public OfferedAppointmentsDTO() {}
    
	public Date getDateOfExamination() {
		return dateOfExamination;
	}
	public void setDateOfExamination(Date dateOfExamination) {
		this.dateOfExamination = dateOfExamination;
	}
	public String getExaminationRoom() {
		return examinationRoom;
	}
	public void setExaminationRoom(String examinationRoom) {
		this.examinationRoom = examinationRoom;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getClinicId() {
		return clinicId;
	}
	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
    
}
