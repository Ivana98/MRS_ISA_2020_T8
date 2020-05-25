package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Disease;

public class DiseaseForNurseDTO {

	private Long id;
	private String name;
	
	
	
	
	public DiseaseForNurseDTO(Disease disease) {
		super();
		this.id = disease.getId();
		this.name = disease.getName();
	}
	
	
	public DiseaseForNurseDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "DiseaseForNurseDTO [id=" + id + ", name=" + name + "]";
	}
	
	

}
