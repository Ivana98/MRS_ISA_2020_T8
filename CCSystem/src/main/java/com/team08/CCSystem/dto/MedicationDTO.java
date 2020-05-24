package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Medication;

public class MedicationDTO {
	private Long id;
	private String name;
	private String description;
	
	public MedicationDTO(Medication m) {
		this.id = m.getId();
		this.name = m.getName();
		this.description = m.getDescription();
	}
	
	public MedicationDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
		return "MedicationDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
}
