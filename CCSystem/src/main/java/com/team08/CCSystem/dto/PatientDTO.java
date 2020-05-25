/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Set;

import com.team08.CCSystem.model.Patient;

/**
 * @author Veljko
 *
 */
public class PatientDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String city;
	private String country;
	private String street;
	private String allergies;
	private String blood_type;
	private String diopter;
	private String height;
	private String weight;
	private String policyholder;
	private String clinical_center_id;
	
	public PatientDTO() {
		
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 * @param password
	 * @param city
	 * @param country
	 * @param street
	 * @param allergy
	 * @param blood_type
	 * @param diopter
	 * @param height
	 * @param weight
	 * @param policyholder
	 * @param clinical_center_id
	 */
	public PatientDTO(Long id, String firstName, String lastName, String email, String phone, String password,
			String city, String country, String street, String allergies, String blood_type, String diopter,
			String height, String weight, String policyholder, String clinical_center_id) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.city = city;
		this.country = country;
		this.street = street;
		this.allergies = allergies;
		this.blood_type = blood_type;
		this.diopter = diopter;
		this.height = height;
		this.weight = weight;
		this.policyholder = policyholder;
		this.clinical_center_id = clinical_center_id;
	}
	
	/**
	 * @param patient
	 */
	public PatientDTO(Patient patient) {
		this.id = patient.getId();
		this.firstName = patient.getName();
		this.lastName = patient.getSurname();
		this.email = patient.getEmail();
		this.phone = patient.getPhone();
		this.password = patient.getPassword();
		this.city = patient.getAddress().getCity();
		this.country = patient.getAddress().getCountry();
		this.street = patient.getAddress().getStreet();
		this.allergies = patient.getAllergy();
		this.blood_type = patient.getBloodType().name();
		this.diopter = patient.getDiopter();
		this.height = patient.getHeight() + "";
		this.weight = patient.getWeight()+ "";
		this.policyholder = patient.getPolicyholder();
		this.clinical_center_id = patient.getClinicalCenter().getId().toString();
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

	public String getAllergy() {
		return allergies;
	}

	public void setAllergy(String allergies) {
		this.allergies = allergies;
	}

	public String getBlood_type() {
		return blood_type;
	}

	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}

	public String getDiopter() {
		return diopter;
	}

	public void setDiopter(String diopter) {
		this.diopter = diopter;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPolicyholder() {
		return policyholder;
	}

	public void setPolicyholder(String policyholder) {
		this.policyholder = policyholder;
	}

	public String getClinical_center_id() {
		return clinical_center_id;
	}

	public void setClinical_center_id(String clinical_center_id) {
		this.clinical_center_id = clinical_center_id;
	}

	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", city=" + city + ", country=" + country
				+ ", street=" + street + ", allergy=" + allergies + ", blood_type=" + blood_type + ", diopter=" + diopter
				+ ", height=" + height + ", weight=" + weight + ", policyholder=" + policyholder
				+ ", clinical_center_id=" + clinical_center_id + "]";
	}
	
}
