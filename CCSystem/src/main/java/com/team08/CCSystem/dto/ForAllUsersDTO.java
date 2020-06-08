package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.enums.BloodType;

public class ForAllUsersDTO {
	private Long userId;
	private String email;
	private String name;
	private String surname;
	//Adress
	private String street;
	private String city;
	private String country;
	
	private String phone;
	private String userAuthority;
	
	//clinic id for admin, nurse and doctor and clinical center id for clinical center id
	private Long clinicId;
	
	//doctor
	private String specialisation;
	private float averageMark;
	
	//patient
	private String policyholder;
	
	// clinic admin, doctor and nurse
	private boolean isPasswordChanged;
	
	public ForAllUsersDTO() {}
	
	public boolean isPasswordChanged() {
		return isPasswordChanged;
	}

	public void setPasswordChanged(boolean isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserAuthority() {
		return userAuthority;
	}
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}
	public Long getClinicId() {
		return clinicId;
	}
	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
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
	public String getPolicyholder() {
		return policyholder;
	}
	public void setPolicyholder(String policyholder) {
		this.policyholder = policyholder;
	}

}
