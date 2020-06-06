/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.team08.CCSystem.model.enums.BloodType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE patient SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "Patient")
public class Patient extends User {

	@Column(name="policyholder", unique=true, nullable=false)
	private String policyholder;
	
	@Column(name="height", nullable=false)
	private int height;
	
	@Column(name="weight", nullable=false)
	private int weight;

	@Enumerated
	private BloodType bloodType;
	
	@Column(name="allergy", nullable=false)
	private String allergy;
	
	@Column(name="diopter", nullable=false)
	private String diopter;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ClinicalCenter clinicalCenter;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = false)
	private Set<Examination> examinations = new HashSet<>();
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = false)
	private Set<ClinicMark> clinicsMarks = new HashSet<>(); //patient evaluates clinics
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = false)
	private Set<DoctorMark> doctorsMarks = new HashSet<>(); //patient evaluates doctors
	
	

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 * @param policyholder
	 * @param height
	 * @param weight
	 * @param bloodType
	 * @param allergy
	 * @param diopter
	 * @param clinicalCenter
	 * @param examinations
	 * @param clinicsMarks
	 * @param doctorsMarks
	 */
	public Patient(Long id, String email, String name, String surname, Address address, String phone,
			String password, String policyholder, int height, int weight, BloodType bloodType,String allergy,
			String diopter, ClinicalCenter clinicalCenter, Set<Examination> examinations, Set<ClinicMark> clinicsMarks,
			Set<DoctorMark> doctorsMarks) {
		super(id, email, name, surname, address, phone, password);
		this.policyholder = policyholder;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.allergy = allergy;
		this.diopter = diopter;
		this.clinicalCenter = clinicalCenter;
		this.examinations = examinations;
		this.clinicsMarks = clinicsMarks;
		this.doctorsMarks = doctorsMarks;
	}

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 */
	public Patient(Long id, String email, String name, String surname, Address address, String phone,
			String password) {
		super(id, email, name, surname, address, phone, password);
	}
	

	public Patient() {}

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

	public ClinicalCenter getClinicalCenter() {
		return clinicalCenter;
	}

	public void setClinicalCenter(ClinicalCenter clinicalCenter) {
		this.clinicalCenter = clinicalCenter;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
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

	@Override
	public String toString() {
		return "Request for patient:" +
				"\nName: " + this.getName() +
				"\nSurname: " + this.getSurname() +
				"\nEmail: " + this.getEmail() +
				"\nStreet: " + this.getAddress().getStreet() +
				"\nCity: " + this.getAddress().getCity() +
				"\nCountry: " + this.getAddress().getCountry() +
				"\nPhone number: " + this.getPhone() +
				"\npolicyholder: " + this.getPolicyholder() ;
	}
	
	
}
