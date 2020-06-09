/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Price;

/**
 * @author Veljko
 *
 */
public class FullPriceDTO {
	
	private Long id;
	private Long clinic_id;
	private double price;
	private float discount;
	
	// ExaminationType attributes
	private String intervention_type;
	private String specialisation;
	private int duration;
	
	/**
	 * @param id
	 * @param clinic_id
	 * @param price
	 * @param intervention_type
	 * @param specialisation
	 * @param duration
	 */
	public FullPriceDTO(Long id, Long clinic_id, double price, float discount, String intervention_type, String specialisation,
			int duration) {
		super();
		this.id = id;
		this.clinic_id = clinic_id;
		this.price = price;
		this.discount = discount;
		this.intervention_type = intervention_type;
		this.specialisation = specialisation;
		this.duration = duration;
	}

	/**
	 * 
	 */
	public FullPriceDTO() {
		super();
	}
	
	/**
	 * @param price
	 */
	public FullPriceDTO(Price price) {
		this.id = price.getId();
		this.clinic_id = price.getClinic().getId();
		this.price = price.getPrice();
		this.discount = price.getDiscount();
		this.intervention_type = price.getExaminationType().getInterventionType().name();
		this.specialisation = price.getExaminationType().getSpecialisation().name();
		this.duration = price.getExaminationType().getDuration();
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(Long clinic_id) {
		this.clinic_id = clinic_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntervention_type() {
		return intervention_type;
	}

	public void setIntervention_type(String intervention_type) {
		this.intervention_type = intervention_type;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "FullPriceDTO [id=" + id + ", clinic_id=" + clinic_id + ", price=" + price + ", intervention_type="
				+ intervention_type + ", specialisation=" + specialisation + ", duration=" + duration + "]";
	}
	
}
