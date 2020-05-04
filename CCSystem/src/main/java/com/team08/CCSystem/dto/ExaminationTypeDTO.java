/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.ExaminationType;

/**
 * @author Veljko
 *
 */
public class ExaminationTypeDTO {
	
	private Long id;
	private double price;
	private String duration;
	private String interventionType;
	private String specialisation;
	
	/**
	 * @param id
	 * @param price
	 * @param interventionType
	 * @param specialisation
	 */
	public ExaminationTypeDTO(Long id, double price, String duration, String interventionType, String specialisation) {
		super();
		this.id = id;
		this.price = price;
		this.duration = duration;
		this.interventionType = interventionType;
		this.specialisation = specialisation;
	}

	/**
	 * 
	 */
	public ExaminationTypeDTO() {
		super();
	}

	/**
	 * @param et
	 */
	public ExaminationTypeDTO(ExaminationType et) {
		this.id = et.getId();
		this.price = et.getPrice();
		this.duration = et.getDuration() + "";
		this.interventionType = et.getInterventionType().name();
		this.specialisation = et.getSpecialisation().name();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInterventionType() {
		return interventionType;
	}
	
	public void setInterventionType(String interventionType) {
		this.interventionType = interventionType;
	}
	
	public String getSpecialisation() {
		return specialisation;
	}
	
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	@Override
	public String toString() {
		return "ExaminationTypeDTO [id=" + id + ", price=" + price + ", duration=" + duration + ", interventionType="
				+ interventionType + ", specialisation=" + specialisation + "]";
	}

}
