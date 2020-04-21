/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team08.CCSystem.model.enums.InterventionType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "MedicalRoom")
public class MedicalRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "roomNumber", nullable = false, unique = true)
	private int roomNumber;
	@Enumerated
	private InterventionType intervensionType;
	
	public MedicalRoom() {
		super();
	}

	public MedicalRoom(Integer id, int roomNumber, InterventionType intervensionType) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.intervensionType = intervensionType;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public InterventionType getIntervensionType() {
		return intervensionType;
	}
	
	public void setIntervensionType(InterventionType intervensionType) {
		this.intervensionType = intervensionType;
	}
	
	
}
