/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Address;

/**
 * @author Veljko
 *
 */
public class AddressDTO {
	private Long id;
	private String street;
	private String city;
	private String country;
	
	public AddressDTO() {
		
	}
	
	public AddressDTO(Address address) {
		this(address.getId(), address.getStreet(), address.getCity(), address.getCountry());
	}

	/**
	 * @param id2
	 * @param street2
	 * @param city2
	 * @param country2
	 */
	public AddressDTO(Long id, String street, String city, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", street=" + street + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
