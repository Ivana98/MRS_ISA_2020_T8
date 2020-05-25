package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.ClinicalCenterAdmin;

public class ClinicalCenterAdminRegistrationDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String country;
	private String city;
	private String street;
	private Long clinicCenter_id;
	
	public ClinicalCenterAdminRegistrationDTO(Long id, String firstName, String lastName, String email, String phone, String password,
			String city, String country, String street , Long clinicCenter_id) {
		
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setPassword(password);
		this.setCity(city);
		this.setCountry(country);
		this.setStreet(street);
		this.setClinicCenter_id(clinicCenter_id);
	}
	
	public ClinicalCenterAdminRegistrationDTO(ClinicalCenterAdmin adm) {
		
		this.setFirstName(adm.getName());
		this.setLastName(adm.getSurname());
		this.setEmail(adm.getEmail());
		this.setPhone(adm.getPhone());
		this.setPassword(adm.getPassword());
		this.setCountry(adm.getAddress().getCountry());
		this.setCity(adm.getAddress().getCity());
		this.setStreet(adm.getAddress().getStreet());
		this.setClinicCenter_id(adm.getClinicalCenter().getId());
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Long getClinicCenter_id() {
		return clinicCenter_id;
	}
	public void setClinicCenter_id(Long clinicCenter_id) {
		this.clinicCenter_id = clinicCenter_id;
	}
	@Override
	public String toString() {
		return "ClinicalCenterAdminDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", password=" + password + ", country=" + country + ", city=" + city
				+ ", street=" + street + ", clinicCenter_id=" + clinicCenter_id + "]";
	}
	
	
}
