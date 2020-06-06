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

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE examination_type SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "ExaminationType")
public class ExaminationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * Duration in minutes
	 */
	@Column(name = "duration", nullable = false)
	private int duration;
	
	@Enumerated
	private InterventionType interventionType;
	
	@Enumerated
	private Specialisation specialisation;
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param price
	 * @param duration
	 * @param interventionType
	 * @param specialisation
	 */
	public ExaminationType(Long id, int duration, InterventionType interventionType,
			Specialisation specialisation) {
		super();
		this.id = id;
		this.duration = duration;
		this.interventionType = interventionType;
		this.specialisation = specialisation;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public ExaminationType() {
		super();
		this.deleted = false;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
	
	

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
