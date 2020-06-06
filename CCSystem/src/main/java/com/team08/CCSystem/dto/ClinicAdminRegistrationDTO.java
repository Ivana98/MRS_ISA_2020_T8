package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.ClinicAdmin;

public class ClinicAdminRegistrationDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String country;
	private String city;
	private String street;
	private String clinic_id;
	
	public ClinicAdminRegistrationDTO(Long id, String firstName, String lastName, String email, String phone, String password,
			String city, String country, String street , String clinic_id) {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setPassword(password);
		this.setCity(city);
		this.setCountry(country);
		this.setStreet(street);
		this.setClinic_id(clinic_id);
	}

	public ClinicAdminRegistrationDTO(ClinicAdmin admin) {
		this.id = admin.getId();
		this.firstName = admin.getName();
		this.lastName = admin.getSurname();
		this.email = admin.getEmail();
		this.phone = admin.getPhone();
		this.password = admin.getPassword();
		this.city = admin.getAddress().getCity();
		this.country = admin.getAddress().getCountry();
		this.street = admin.getAddress().getStreet();
		this.clinic_id =admin.getClinic().getId().toString();
	}
	
	/**
	 * 
	 */
	public ClinicAdminRegistrationDTO() {
		super();
	}

	public String getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "ClinicAdminDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", city=" + city + ", country=" + country
				+ ", street=" + street + ", clinic_id=" + clinic_id + "]";
	}
}
