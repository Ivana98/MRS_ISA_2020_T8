/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

import com.team08.CCSystem.model.Examination;

/**
 * @author Veljko
 *
 */
public class ExaminationDTO {
	
	private Long id;
	private Date date;
	private boolean wasOnExamination;
	private String description;
	private float discount;
	private Long medicalRoomId;
	private Long doctorId;
	private Long patientId;
	private int duration;
	private String specialisation;
	private String interventionType;
	private double price;
	private Long priceId;
	
	/**
	 * @param id
	 * @param date
	 * @param wasOnExamination
	 * @param description
	 * @param discount
	 * @param medicalRoomId
	 * @param doctorId
	 * @param patientId
	 * @param duration
	 * @param specialisation
	 * @param interventionType
	 */
	public ExaminationDTO(Long id, Date date, boolean wasOnExamination, String description, float discount,
			Long medicalRoomId, Long doctorId, Long patientId, int duration, String specialisation,
			String interventionType, double price, Long priceId) {
		super();
		this.id = id;
		this.date = date;
		this.wasOnExamination = wasOnExamination;
		this.description = description;
		this.discount = discount;
		this.medicalRoomId = medicalRoomId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.duration = duration;
		this.specialisation = specialisation;
		this.interventionType = interventionType;
		this.price = price;
		this.priceId = priceId;
	}
	
	/**
	 * 
	 */
	public ExaminationDTO() {
		super();
	}
	
	/**
	 * 
	 */
	public ExaminationDTO(Examination examination) {
		//TODO:
		this.id = examination.getId();
		this.date = examination.getDate();
		this.wasOnExamination = examination.getWasOnExamination();
		
		// description can be null if it is free examination
		try { this.description = examination.getDescription(); } catch (Exception e) { }
		
		this.discount = examination.getPrice().getDiscount();
		this.medicalRoomId = examination.getMedicalRoom().getId();
		this.doctorId = examination.getDoctor().getId();
		
		// if it is free examination, then patient id is null 
		try { this.patientId = examination.getPatient().getId(); } catch (NullPointerException e) { }
		
		this.duration = examination.getPrice().getExaminationType().getDuration();
		this.specialisation = examination.getPrice().getExaminationType().getSpecialisation().name();
		this.interventionType = examination.getPrice().getExaminationType().getInterventionType().name();
		this.price = examination.getStaticPrice();
		this.priceId = examination.getPrice().getId();
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

	public Long getMedicalRoomId() {
		return medicalRoomId;
	}

	public void setMedicalRoomId(Long medicalRoomId) {
		this.medicalRoomId = medicalRoomId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public String getInterventionType() {
		return interventionType;
	}

	public void setInterventionType(String interventionType) {
		this.interventionType = interventionType;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long price) {
		this.priceId = price;
	}

	@Override
	public String toString() {
		return "ExaminationDTO [id=" + id + ", date=" + date + ", wasOnExamination=" + wasOnExamination
				+ ", description=" + description + ", discount=" + discount + ", medicalRoomId=" + medicalRoomId
				+ ", doctorId=" + doctorId + ", patientId=" + patientId + ", duration=" + duration + ", specialisation="
				+ specialisation + ", interventionType=" + interventionType + ", price=" + price + ", priceId="
				+ priceId + "]";
	}

}
