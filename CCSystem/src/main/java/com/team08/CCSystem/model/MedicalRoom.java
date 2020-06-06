/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.team08.CCSystem.model.enums.InterventionType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE medical_room SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "MedicalRoom")
public class MedicalRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "roomNumber", nullable = false, unique = true)
	private String roomNumber;
	
	@Enumerated
	private InterventionType intervensionType;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Clinic clinic;
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param roomNumber
	 * @param intervensionType
	 * @param clinic
	 */
	public MedicalRoom(Long id, String roomNumber, InterventionType intervensionType, Clinic clinic) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.intervensionType = intervensionType;
		this.clinic = clinic;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public MedicalRoom() {
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

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public InterventionType getIntervensionType() {
		return intervensionType;
	}

	public void setIntervensionType(InterventionType intervensionType) {
		this.intervensionType = intervensionType;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

}
