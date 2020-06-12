/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

import com.team08.CCSystem.model.Examination;

/**
 * @author Veljko
 *
 */
public class ExaminationRequestDTO {
	
	private Long clinicId;
	private Long doctorId;
	private Long patientId;
	private String interventionType;
	private Date date;
	
	/**
	 * @param clinicId
	 * @param doctorId
	 * @param patientId
	 * @param interventionType
	 * @param date
	 */
	public ExaminationRequestDTO(Long clinicId, Long doctorId, Long patientId, String interventionType, Date date) {
		super();
		this.clinicId = clinicId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.interventionType = interventionType;
		this.date = date;
	}

	/**
	 * 
	 */
	public ExaminationRequestDTO() {
		super();
	}

	/**
	 * @param examiantion
	 */
	public ExaminationRequestDTO(Examination examiantion) {
		this.clinicId = examiantion.getDoctor().getClinic().getId();
		this.doctorId = examiantion.getDoctor().getId();
		this.patientId = examiantion.getPatient().getId();
		this.interventionType = examiantion.getPrice().getExaminationType().getInterventionType().name();
		this.date = examiantion.getDate();
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getInterventionType() {
		return interventionType;
	}

	public void setInterventionType(String interventionType) {
		this.interventionType = interventionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExaminationRequestDTO [clinicId=" + clinicId + ", doctorId=" + doctorId + ", patientId=" + patientId
				+ ", interventionType=" + interventionType + ", date=" + date + "]";
	}
	
}
