/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street", nullable = false, unique = false)
	private String street;
	
	@Column(name = "city", nullable = false, unique = false)
	private String city;
	
	@Column(name = "country", nullable = false, unique = false)
	private String country;

	/**
	 * @param id
	 * @param street
	 * @param city
	 * @param country
	 */
	public Address(Long id, String street, String city, String country) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	/**
	 * 
	 */
	public Address() {
		super();
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
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", country=" + country + "]";
	}
	
}
