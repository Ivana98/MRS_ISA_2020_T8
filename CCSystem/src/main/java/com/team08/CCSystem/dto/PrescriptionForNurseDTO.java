package com.team08.CCSystem.dto;

import java.util.Date;

import com.team08.CCSystem.model.Prescription;

public class PrescriptionForNurseDTO {
	
	private Long id;
	private boolean validated;
	private int quantity;
	private Date expirationDate; //expiration date of prescription
	//Nurse
	private String nurse_id;
	private String nurse_name;
	//Medication
	private String medication_id;
	private String medication_name;
	
	private String description;

	
	public PrescriptionForNurseDTO(Prescription p) {
		super();
		this.id = p.getId();
		this.validated = p.isValidated();
		this.quantity = p.getQuantity();
		this.expirationDate = p.getExpirationDate();
		this.nurse_id = p.getNurse().getId() + "";
		this.nurse_name = p.getNurse().getName();
		this.medication_id = p.getMedication().getId() + "";
		this.medication_name = p.getMedication().getName();
		this.description = p.getDescription();
	}
	
	public PrescriptionForNurseDTO(Long id, boolean validated, int quantity, Date expirationDate, String nurse_id,
			String nurse_name, String medication_id, String medication_name, String description) {
		super();
		this.id = id;
		this.validated = validated;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
		this.nurse_id = nurse_id;
		this.nurse_name = nurse_name;
		this.medication_id = medication_id;
		this.medication_name = medication_name;
		this.description = description;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getNurse_id() {
		return nurse_id;
	}
	public void setNurse_id(String nurse_id) {
		this.nurse_id = nurse_id;
	}
	public String getNurse_name() {
		return nurse_name;
	}
	public void setNurse_name(String nurse_name) {
		this.nurse_name = nurse_name;
	}
	public String getMedication_id() {
		return medication_id;
	}
	public void setMedication_id(String medication_id) {
		this.medication_id = medication_id;
	}
	public String getMedication_name() {
		return medication_name;
	}
	public void setMedication_name(String medication_name) {
		this.medication_name = medication_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PrescriptionDTO [id=" + id + ", validated=" + validated + ", quantity=" + quantity + ", expirationDate="
				+ expirationDate + ", nurse_id=" + nurse_id + ", nurse_name=" + nurse_name + ", medication_id="
				+ medication_id + ", medication_name=" + medication_name + ", description=" + description + "]";
	}

}
