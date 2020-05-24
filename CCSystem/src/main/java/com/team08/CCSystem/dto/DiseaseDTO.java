package com.team08.CCSystem.dto;

import java.util.Set;

import com.team08.CCSystem.model.Disease;
import com.team08.CCSystem.model.Examination;

public class DiseaseDTO {

	private Long id;
	private String name;
	private String description;
	private Set<Examination> examinations;
	
	
	public DiseaseDTO(Disease disease) {
		this.id = disease.getId();
		this.name = disease.getName();
		this.description = disease.getDescription();
		this.examinations = disease.getExaminations();
		
	}
	
	public DiseaseDTO(Long id, String name, String description, Set<Examination> examinations) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.examinations = examinations;
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
	public Set<Examination> getExaminations() {
		return examinations;
	}
	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}
	@Override
	public String toString() {
		return "DiseaseDTO [id=" + id + ", name=" + name + ", description=" + description + ", examinations="
				+ examinations + "]";
	}
	
	

}

