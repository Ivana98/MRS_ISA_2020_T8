/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Set;

import com.team08.CCSystem.model.Disease;

/**
 * @author Veljko
 *
 */
public class DiseaseMREDTO {
	
	private Long id;
	private String name;
	private String description;
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public DiseaseMREDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	/**
	 * @param disease
	 */
	public DiseaseMREDTO(Disease disease) {
		super();
		this.id = disease.getId();
		this.name = disease.getName();
		this.description = disease.getDescription();
	}
	
	/**
	 * 
	 */
	public DiseaseMREDTO() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DiseaseMREDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
