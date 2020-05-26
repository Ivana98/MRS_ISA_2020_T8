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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "wasOnExamination", nullable = false)
	private boolean wasOnExamination;
	
	@Column(name = "description", nullable = true) 
	private String description;
	
	@Column(name = "discount", nullable = true) 
	private float discount;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Price price;
	
	@ManyToMany(mappedBy = "examinations")
	private Set<Prescription> prescriptions = new HashSet<>();
	
	@ManyToMany(mappedBy = "examinations")
	private Set<Disease> diseases = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="medical_room_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
	private MedicalRoom medicalRoom;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Doctor doctor;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Patient patient;

	/**
	 * @param id
	 * @param date
	 * @param wasOnExamination
	 * @param description
	 * @param discount
	 * @param price
	 * @param prescriptions
	 * @param diseases
	 * @param medicalRoom
	 * @param doctor
	 * @param patient
	 */
	public Examination(Long id, Date date, boolean wasOnExamination, String description, float discount,
			Price price, Set<Prescription> prescriptions, Set<Disease> diseases, MedicalRoom medicalRoom,
			Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.date = date;
		this.wasOnExamination = wasOnExamination;
		this.description = description;
		this.discount = discount;
		this.price = price;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getWasOnExamination() {
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

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
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
