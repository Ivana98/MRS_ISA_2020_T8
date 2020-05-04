/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.MedicalRoom;

/**
 * @author Veljko
 *
 */
public class MedicalRoomDTO {
	
	private Long id;
	private String room_number;
	private String intervention_type;
	private String clinic_id;
	
	/**
	 * @param id
	 * @param room_number
	 * @param intervention_type
	 */
	public MedicalRoomDTO(Long id, String room_number, String intervention_type, String clinic_id) {
		super();
		this.id = id;
		this.room_number = room_number;
		this.intervention_type = intervention_type;
		this.clinic_id = clinic_id;
	}
	
	/**
	 * Empty constructor
	 */
	public MedicalRoomDTO() {
		super();
	}

	/**
	 * @param mRoom
	 */
	public MedicalRoomDTO(MedicalRoom mRoom) {
		this.id = mRoom.getId();
		this.room_number = mRoom.getRoomNumber();
		this.intervention_type = mRoom.getIntervensionType().toString();
		this.clinic_id = mRoom.getClinic().getId().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getroom_number() {
		return room_number;
	}

	public void setroom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getintervention_type() {
		return intervention_type;
	}

	public void setintervention_type(String intervention_type) {
		this.intervention_type = intervention_type;
	}

	public String getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}

	@Override
	public String toString() {
		return "MedicalRoomDTO [id=" + id + ", room_number=" + room_number + ", intervention_type=" + intervention_type + ", clinic_id="
				+ clinic_id + "]";
	}
	
}
