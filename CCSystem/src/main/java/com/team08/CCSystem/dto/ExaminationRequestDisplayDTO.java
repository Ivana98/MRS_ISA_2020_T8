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
public class ExaminationRequestDisplayDTO {
	
	public Long id;
	public Long clinicId;
    public Long doctorId;
    public String doctorName;
    public String doctorSurname;
    public String doctorSpecialisation;
    public Long patientId;
    public String patientName;
    public String patientSurname;
    public String interventionType;
    public Date date;
    
	/**
	 * @param clinicId
	 * @param doctorId
	 * @param doctorName
	 * @param doctorSurname
	 * @param doctorSpecialisation
	 * @param patientId
	 * @param patientName
	 * @param patientSurname
	 * @param interventionType
	 * @param date
	 */
	public ExaminationRequestDisplayDTO(Long id, Long clinicId, Long doctorId, String doctorName, String doctorSurname,
			String doctorSpecialisation, Long patientId, String patientName, String patientSurname,
			String interventionType, Date date) {
		super();
		this.id = id;
		this.clinicId = clinicId;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSurname = doctorSurname;
		this.doctorSpecialisation = doctorSpecialisation;
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
		this.interventionType = interventionType;
		this.date = date;
	}
	
	/**
	 * 
	 */
	public ExaminationRequestDisplayDTO() {
		super();
	}
	
	/**
	 * @param examination
	 */
	public ExaminationRequestDisplayDTO(Examination examination) {
		this.id = examination.getId();
		this.clinicId = examination.getDoctor().getClinic().getId();
		this.doctorId = examination.getDoctor().getId();
		this.doctorName = examination.getDoctor().getName();
		this.doctorSurname = examination.getDoctor().getSurname();
		this.doctorSpecialisation = examination.getDoctor().getSpecialisation().name();
		this.patientId = examination.getPatient().getId();
		this.patientName = examination.getPatient().getName();
		this.patientSurname = examination.getPatient().getSurname();
		this.interventionType = examination.getPrice().getExaminationType().getInterventionType().name();
		this.date = examination.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSurname() {
		return doctorSurname;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}

	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSurname() {
		return patientSurname;
	}

	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
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
		return "ExaminationRequestDisplayDTO [clinicId=" + clinicId + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", doctorSurname=" + doctorSurname + ", doctorSpecialisation=" + doctorSpecialisation
				+ ", patientId=" + patientId + ", patientName=" + patientName + ", patientSurname=" + patientSurname
				+ ", interventionType=" + interventionType + ", date=" + date + "]";
	}

}
