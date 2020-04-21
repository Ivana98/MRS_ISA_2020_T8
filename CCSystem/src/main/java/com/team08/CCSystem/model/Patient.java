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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.team08.CCSystem.model.enums.BloodType;

/**
 * @author Veljko
 *
 */
@Entity
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
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Examination> examinations = new HashSet<>();
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicMark> clinicsMarks = new HashSet<>(); //patient evaluates clinics
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DoctorMark> doctorsMarks = new HashSet<>(); //patient evaluates doctors
	
	public Patient() {
		super();
	}
	
	public Patient(String policyholder, int height, int weight, BloodType bloodType, String allergy, String diopter,
			Set<Examination> examinations, Set<ClinicMark> clinicsMarks, Set<DoctorMark> doctorsMarks) {
		super();
		this.policyholder = policyholder;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.allergy = allergy;
		this.diopter = diopter;
		this.examinations = examinations;
		this.clinicsMarks = clinicsMarks;
		this.doctorsMarks = doctorsMarks;
	}

	public Set<ClinicMark> getClinicsMarks() {
		return clinicsMarks;
	}

	public void setClinicsMarks(Set<ClinicMark> clinicsMarks) {
		this.clinicsMarks = clinicsMarks;
	}

	public Set<DoctorMark> getDoctorsMarks() {
		return doctorsMarks;
	}

	public void setDoctorsMarks(Set<DoctorMark> doctorsMarks) {
		this.doctorsMarks = doctorsMarks;
	}

	public String getPolicyholder() {
		return policyholder;
	}
	
	public void setPolicyholder(String policyholder) {
		this.policyholder = policyholder;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public BloodType getBloodType() {
		return bloodType;
	}
	
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	
	public String getAllergy() {
		return allergy;
	}
	
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	public String getDiopter() {
		return diopter;
	}
	
	public void setDiopter(String diopter) {
		this.diopter = diopter;
	}
	
	public Set<Examination> getExaminations() {
		return examinations;
	}
	
	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}
	
}
