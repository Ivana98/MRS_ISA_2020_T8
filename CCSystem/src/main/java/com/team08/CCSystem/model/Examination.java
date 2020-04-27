/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "Examination")
public class Examination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, unique = false)
	private Date date;
	
	@Column(name = "wasOnExamination", nullable = false, unique = false)
	private boolean wasOnExamination;
	
	@Column(name = "description", nullable = false, unique = false) 
	private String description;
	
	@Column(name = "discount", nullable = false, unique = false) 
	private float discount;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ExaminationType examinationType;
	
	@ManyToMany(mappedBy = "examinations")
	private Set<Prescription> prescriptions = new HashSet<>();
	
	@ManyToMany(mappedBy = "examinations")
	private Set<Disease> diseases = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MedicalRoom medicalRoom;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Doctor doctor; //doctor
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;

	/**
	 * @param id
	 * @param date
	 * @param wasOnExamination
	 * @param description
	 * @param discount
	 * @param examinationType
	 * @param prescriptions
	 * @param diseases
	 * @param medicalRoom
	 * @param doctor
	 * @param patient
	 */
	public Examination(Integer id, Date date, boolean wasOnExamination, String description, float discount,
			ExaminationType examinationType, Set<Prescription> prescriptions, Set<Disease> diseases,
			MedicalRoom medicalRoom, Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.date = date;
		this.wasOnExamination = wasOnExamination;
		this.description = description;
		this.discount = discount;
		this.examinationType = examinationType;
		this.prescriptions = prescriptions;
		this.diseases = diseases;
		this.medicalRoom = medicalRoom;
		this.doctor = doctor;
		this.patient = patient;
	}

	/**
	 * 
	 */
	public Examination() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isWasOnExamination() {
		return wasOnExamination;
	}

	public void setWasOnExamination(boolean wasOnExamination) {
		this.wasOnExamination = wasOnExamination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public ExaminationType getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Set<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(Set<Disease> diseases) {
		this.diseases = diseases;
	}

	public MedicalRoom getMedicalRoom() {
		return medicalRoom;
	}

	public void setMedicalRoom(MedicalRoom medicalRoom) {
		this.medicalRoom = medicalRoom;
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
