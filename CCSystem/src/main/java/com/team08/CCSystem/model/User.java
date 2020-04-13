package com.team08.CCSystem.model;

public class User {
	private String policyholder;
	private String email;
	private String name;
	private String surname;
	private String adress;
	private String city;
	private String country;
	private String phone;
	
	public User() {}
	
	public User(String policyholder, String email, String name, String surname, String adress, String city,
			String country, String phone) {
		super();
		this.policyholder = policyholder;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.phone = phone;
	}

	public String getPolicyholder() {
		return policyholder;
	}

	public void setPolicyholder(String policyholder) {
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
	
}
