/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Veljko
 *
 * Patients give marks to clinic
 */
@Entity
@Data
@Table(name = "ClinicalMark")
public class ClinicMark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "mark", nullable = false, unique = false)
	private float mark; //from 0 to 5
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;
	
	public ClinicMark() {
		super();
	}

	public ClinicMark(Integer id, float mark, Patient patient, Clinic clinic) {
		super();
		this.id = id;
		this.mark = mark;
		this.patient = patient;
		this.clinic = clinic;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public float getMark() {
		return mark;
	}
	
	public void setMark(float mark) {
		this.mark = mark;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	
}
