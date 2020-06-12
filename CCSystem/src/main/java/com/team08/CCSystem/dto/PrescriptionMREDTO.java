/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

import com.team08.CCSystem.model.Prescription;

/**
 * @author Veljko
 *
 */
public class PrescriptionMREDTO {
	
	public Long id;
    public boolean validated;
    public int quantity;
    public Date date;
    public Long nurse_id;
    public String nurse_name;
    public Long medication_id;
    public String medication_name;
    public String description;
    
	/**
	 * @param id
	 * @param validated
	 * @param quantity
	 * @param date
	 * @param nurse_id
	 * @param nurse_name
	 * @param medication_id
	 * @param medication_name
	 * @param description
	 */
	public PrescriptionMREDTO(Long id, boolean validated, int quantity, Date date, Long nurse_id, String nurse_name,
			Long medication_id, String medication_name, String description) {
		super();
		this.id = id;
		this.validated = validated;
		this.quantity = quantity;
		this.date = date;
		this.nurse_id = nurse_id;
		this.nurse_name = nurse_name;
		this.medication_id = medication_id;
		this.medication_name = medication_name;
		this.description = description;
	}
	
	/**
	 * @param prescription
	 */
	public PrescriptionMREDTO(Prescription prescription) {
		super();
		this.id = prescription.getId();
		this.validated = prescription.isValidated();
		this.quantity = prescription.getQuantity();
		this.date = prescription.getExpirationDate();
		this.nurse_id = prescription.getNurse().getId();
		this.nurse_name = prescription.getNurse().getName();
		this.medication_id = prescription.getMedication().getId();
		this.medication_name = prescription.getMedication().getName();
		this.description = prescription.getDescription();
	}

	/**
	 * 
	 */
	public PrescriptionMREDTO() {
		super();
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getNurse_id() {
		return nurse_id;
	}

	public void setNurse_id(Long nurse_id) {
		this.nurse_id = nurse_id;
	}

	public String getNurse_name() {
		return nurse_name;
	}

	public void setNurse_name(String nurse_name) {
		this.nurse_name = nurse_name;
	}

	public Long getMedication_id() {
		return medication_id;
	}

	public void setMedication_id(Long medication_id) {
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
		return "PrescriptionMREDTO [id=" + id + ", validated=" + validated + ", quantity=" + quantity + ", date=" + date
				+ ", nurse_id=" + nurse_id + ", nurse_name=" + nurse_name + ", medication_id=" + medication_id
				+ ", medication_name=" + medication_name + ", description=" + description + "]";
	}
    
}
