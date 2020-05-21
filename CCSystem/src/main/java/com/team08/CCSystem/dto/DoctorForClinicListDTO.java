package com.team08.CCSystem.dto;

public class DoctorForClinicListDTO {
	private String firstName;
    private String lastName;
    private String phone;
    private Long clinic_id;
    private String specialisation;
    private float averageMark;
    
    public DoctorForClinicListDTO() {}
    
	public DoctorForClinicListDTO(String firstName, String lastName, String phone, Long clinic_id,
			String specialisation, float averageMark) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.clinic_id = clinic_id;
		this.specialisation = specialisation;
		this.averageMark = averageMark;
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

}
