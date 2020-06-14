/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

/**
 * @author Veljko
 *
 */
public class ApprovedExaminationRequestDTO {
	
	private Long id;
	private Long medicalRoomId;
	private Long clinicId;
	private Date newDate;
	
	/**
	 * @param id
	 * @param medicalRoomId
	 */
	public ApprovedExaminationRequestDTO(Long id, Long medicalRoomId, Long clinicId, Date newDate) {
		super();
		this.id = id;
		this.medicalRoomId = medicalRoomId;
		this.clinicId = clinicId;
		this.newDate = newDate;
	}

	/**
	 * 
	 */
	public ApprovedExaminationRequestDTO() {
		super();
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMedicalRoomId() {
		return medicalRoomId;
	}

	public void setMedicalRoomId(Long medicalRoomId) {
		this.medicalRoomId = medicalRoomId;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	@Override
	public String toString() {
		return "ApprovedExaminationRequestDTO [id=" + id + ", medicalRoomId=" + medicalRoomId + ", clinicId=" + clinicId
				+ "]";
	}

}
