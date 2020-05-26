/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Doctor;

/**
 * @author Veljko
 *
 */
public class DoctorAverageMarkDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	private Long clinic_id;
	private String specialisation;
	private float averageMark;
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param clinic_id
	 * @param specialisation
	 * @param averageMark
	 */
	public DoctorAverageMarkDTO(Long id, String firstName, String lastName, String phone, Long clinic_id,
			String specialisation, float averageMark) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.clinic_id = clinic_id;
		this.specialisation = specialisation;
		this.averageMark = averageMark;
	}

	/**
	 * 
	 */
	public DoctorAverageMarkDTO() {
		super();
	}

	/**
	 * @param doctor
	 */
	public DoctorAverageMarkDTO(Doctor doctor) {
		this.id = doctor.getId();
		this.firstName = doctor.getName();
		this.lastName = doctor.getSurname();
		this.phone = doctor.getPhone();
		this.clinic_id = doctor.getClinic().getId();
		this.specialisation = doctor.getSpecialisation().name();
		this.averageMark = doctor.getAverageMark();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(Long clinic_id) {
		this.clinic_id = clinic_id;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

	@Override
	public String toString() {
		return "DoctorAverageMarkDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", clinic_id=" + clinic_id + ", specialisation=" + specialisation + ", averageMark="
				+ averageMark + "]";
	}
	
}
