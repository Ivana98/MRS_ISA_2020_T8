/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Clinic;

/**
 * @author Veljko
 *
 * ClinicBasic on client page
 */
public class ClinicDTO {
	
	private Long id;
	private String name;
	private String street;
	private String city;
	private String country;
	private String description;
	private float averageMark;
	
	/**
	 * @param id
	 * @param name
	 * @param street
	 * @param city
	 * @param country
	 * @param description
	 * @param averageMark
	 */
	public ClinicDTO(Long id, String name, String street, String city, String country, String description,
			float averageMark) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.description = description;
		this.averageMark = averageMark;
	}
	
	/**
	 * 
	 */
	public ClinicDTO() {
		super();
	}
	
	/**
	 * 
	 */
	public ClinicDTO(Clinic clinic) {
		this.id = clinic.getId();
		this.name = clinic.getName();
		this.street = clinic.getAddress().getStreet();
		this.city = clinic.getAddress().getCity();
		this.country = clinic.getAddress().getCountry();
		this.description = clinic.getDescription();
		this.averageMark = clinic.getAverageMark();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getAverageMark() {
		return averageMark;
	}
	
	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}
	
	@Override
	public String toString() {
		return "ClinicDTO [id=" + id + ", name=" + name + ", street=" + street + ", city=" + city + ", country="
				+ country + ", description=" + description + ", averageMark=" + averageMark + "]";
	}
	
}
