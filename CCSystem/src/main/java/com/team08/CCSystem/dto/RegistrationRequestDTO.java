package com.team08.CCSystem.dto;

public class RegistrationRequestDTO {
	private String email;
	private String name;
	private String surname;
	private String street;
	private String city;
	private String country;
	private String phone;
	private String password;
	private String policyholder;
	
	public RegistrationRequestDTO() {}
	
	public RegistrationRequestDTO(String email, String name, String surname, String street, String city, String country,
			String phone, String password, String policyholder) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.street = street;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.password = password;
		this.policyholder = policyholder;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPolicyholder() {
		return policyholder;
	}
	public void setPolicyholder(String policyholder) {
		this.policyholder = policyholder;
	}

}
