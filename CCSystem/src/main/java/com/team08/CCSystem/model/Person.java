/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Veljko
 *
 */
@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	private Long id;
	
	@Column(name= "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * @param id
	 * @param name
	 */
	public Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() { }

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
	
	
}
