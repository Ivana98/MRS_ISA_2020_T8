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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE examination SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
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
	
	@Column(name = "staticPrice", nullable = true) 
	private double staticPrice;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Price price;
	
	@ManyToMany(mappedBy = "examinations")
	private Set<Prescription> prescriptions = new HashSet<>();
	
	@ManyToMany(mappedBy = "examinations")
	private Set<Disease> diseases = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalRoom medicalRoom;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Doctor doctor;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Patient patient;
	
	@Column(nullable = false)
	private Boolean deleted;

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
	public Examination(Long id, Date date, boolean wasOnExamination, String description, double staticPrice,
			Price price, Set<Prescription> prescriptions, Set<Disease> diseases, MedicalRoom medicalRoom,
			Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.date = date;
		this.wasOnExamination = wasOnExamination;
		this.description = description;
		this.staticPrice = staticPrice;
		this.price = price;
		this.prescriptions = prescriptions;
		this.diseases = diseases;
		this.medicalRoom = medicalRoom;
		this.doctor = doctor;
		this.patient = patient;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public Examination() {
		super();
		this.deleted = false;
	}
	
	/*
	 * Method to count price by current pricelist.
	 */
	public double countStaticPrice() {
		double price = this.price.getPrice();
		float discount = this.price.getDiscount();
		
		return price * (100.0 - discount) / 100.0;
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

	public double getStaticPrice() {
		return staticPrice;
	}

	public void setStaticPrice(double staticPrice) {
		this.staticPrice = staticPrice;
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
