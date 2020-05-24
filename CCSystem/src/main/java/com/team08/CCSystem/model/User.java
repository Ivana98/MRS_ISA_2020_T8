package com.team08.CCSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "cust_seq_user")
	@SequenceGenerator(name = "cust_seq_user", sequenceName = "cust_seq_user", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="surname", nullable=false)
	private String surname;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
	
	@Column(name="phone", nullable=false)
	private String phone;
	
	@Column(name="password", nullable=false)
	private String password;

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 */
	public User(Long id, String email, String name, String surname, Address address, String phone, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
	
}
