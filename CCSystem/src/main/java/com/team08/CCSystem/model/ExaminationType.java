/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "ExaminationType")
public class ExaminationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "price", nullable = false, unique = false)
	private double price;
	
	@Column(name = "duration", nullable = false, unique = false)
	private int duration;
	
	@Enumerated
	private InterventionType interventionType;
	
	@Enumerated
	private Specialisation specialisation;

	/**
	 * @param id
	 * @param price
	 * @param duration
	 * @param interventionType
	 * @param specialisation
	 */
	public ExaminationType(Integer id, double price, int duration, InterventionType interventionType,
			Specialisation specialisation) {
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
	public ExaminationType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public InterventionType getInterventionType() {
		return interventionType;
	}

	public void setInterventionType(InterventionType interventionType) {
		this.interventionType = interventionType;
	}

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}
	
	
}
