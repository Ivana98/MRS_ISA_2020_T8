package com.team08.CCSystem.dto;

import java.util.Set;

public class MedicalRecordsDTO {
	private String name;
	private String surname;
	private String policyholder;
	private int height;
	private int weight;
	private String bloodType;
	private String allergies;
	private String diopter;
	
	public MedicalRecordsDTO() {}
	
	
	
	public MedicalRecordsDTO(String name, String surname, String policyholder, int height, int weight, String bloodType,
			String allergies, String diopter) {
		super();
		this.name = name;
		this.surname = surname;
		this.policyholder = policyholder;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.allergies = allergies;
		this.diopter = diopter;
	}

	public String getPolicyholder() {
		return policyholder;
	}
	public void setPolicyholder(String policyholder) {
		this.policyholder = policyholder;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getDiopter() {
		return diopter;
	}
	public void setDiopter(String diopter) {
		this.diopter = diopter;
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

}
