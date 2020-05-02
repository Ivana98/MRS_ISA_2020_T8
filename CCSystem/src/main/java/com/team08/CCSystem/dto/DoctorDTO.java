/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Doctor;

/**
 * @author Veljko
 *
 */
public class DoctorDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String city;
	private String country;
	private String street;
	private String clinic_id;
	private String specialisation;
	
	public DoctorDTO() {
		
	}
	
//	public DoctorDTO(Doctor doctor) {
//		this(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getEmail(), doctor.getPhone(), doctor.getPassword(), doctor.getAddress().getCity(), doctor.getAddress().getCountry(), doctor.getAddress().getStreet());
//	}

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
	 * @param clinicId
	 * @param specialisation
	 */
	public DoctorDTO(Long id, String firstName, String lastName, String email, String phone, String password,
			String city, String country, String street, String clinicId, String specialisation) {
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
		this.clinic_id = clinicId;
		this.specialisation = specialisation;
	}

	/**
	 * @param doctor
	 */
	public DoctorDTO(Doctor doctor) {
		this.id = doctor.getId();
		this.firstName = doctor.getName();
		this.lastName = doctor.getSurname();
		this.email = doctor.getEmail();
		this.phone = doctor.getPhone();
		this.password = doctor.getPassword();
		this.city = doctor.getAddress().getCity();
		this.country = doctor.getAddress().getCountry();
		this.street = doctor.getAddress().getStreet();
		this.clinic_id = doctor.getClinic().getId().toString();
		this.specialisation = doctor.getSpecialisation().toString();
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

	public String getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	@Override
	public String toString() {
		return "DoctorDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", city=" + city + ", country=" + country
				+ ", street=" + street + ", clinic_id=" + clinic_id + ", specialisation=" + specialisation + "]";
	}

}
