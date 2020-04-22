/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.team08.CCSystem.model.enums.BloodType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "Patient")
public class Patient extends User {

	@Column(name="policyholder", unique=true, nullable=false)
	private String policyholder;
	
	@Column(name="height", unique=false, nullable=false)
	private int height;
	
	@Column(name="weight", unique=false, nullable=false)
	private int weight;

	@Enumerated
	private BloodType bloodType;
	
	@Column(name="allergy", unique=false, nullable=false)
	private String allergy;
	
	@Column(name="diopter", unique=false, nullable=false)
	private String diopter;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ClinicalCenter clinicalCenter;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Examination> examinations = new HashSet<>();
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicMark> clinicsMarks = new HashSet<>(); //patient evaluates clinics
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DoctorMark> doctorsMarks = new HashSet<>(); //patient evaluates doctors
	
	
}
