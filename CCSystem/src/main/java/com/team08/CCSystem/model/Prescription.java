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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Data
@SQLDelete(sql = "UPDATE prescription SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Entity
@Table(name = "Prescription")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "validated", nullable = false)
	private boolean validated;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expirationDate", nullable = false)
	private Date expirationDate; //expiration date of prescription
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Nurse nurse;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Medication medication;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "prescriptioning", joinColumns = @JoinColumn(name = "prescription_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"))
	private Set<Examination> examinations = new HashSet<Examination>();
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param validated
	 * @param quantity
	 * @param expirationDate
	 * @param nurse
	 * @param medication
	 * @param description
	 * @param examinations
	 */
	public Prescription(Long id, boolean validated, int quantity, Date expirationDate, Nurse nurse,
			Medication medication, String description, Set<Examination> examinations) {
		super();
		this.id = id;
		this.validated = validated;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
		this.nurse = nurse;
		this.medication = medication;
		this.description = description;
		this.examinations = examinations;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public Prescription() {
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

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}
	
}
