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
 */
@Entity
@Data
@Table(name = "DoctorMark")
public class DoctorMark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "mark", nullable = false, unique = false)
	private float mark; //from 0 to 5
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Doctor doctor;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;

	/**
	 * @param id
	 * @param mark
	 * @param doctor
	 * @param patient
	 */
	public DoctorMark(Long id, float mark, Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.mark = mark;
		this.doctor = doctor;
		this.patient = patient;
	}

	/**
	 * 
	 */
	public DoctorMark() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
