package com.team08.CCSystem.dto;

import java.util.Date;

public class OfferedAppointmentsDTO {
	private Date dateOfExamination; //date and time
    private String examinationRoom;
    public String doctorsName; // name and surname
    public String examinationType; 
    public double price;
    public float discount;
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
    
}
