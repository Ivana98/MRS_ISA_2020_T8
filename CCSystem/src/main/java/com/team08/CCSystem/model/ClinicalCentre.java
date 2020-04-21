package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "ClinicalCentre")
public class ClinicalCentre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@OneToMany(mappedBy = "ClinicalCentre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Clinic> clinics = new HashSet<Clinic>();
	@OneToMany(mappedBy = "ClinicalCentre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patient> patients = new HashSet<>();
	@OneToMany(mappedBy = "ClinicalCentre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicalCenterAdmin> admins = new HashSet<>();
	
	public ClinicalCentre() {
		super();
	}

	public ClinicalCentre(Integer id, String name, Set<Clinic> clinics, Set<Patient> patients,
			Set<ClinicalCenterAdmin> admins) {
		super();
		this.id = id;
		this.name = name;
		this.clinics = clinics;
		this.patients = patients;
		this.admins = admins;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Clinic> getClinics() {
		return clinics;
	}
	
	public void setClinics(Set<Clinic> clinics) {
		this.clinics = clinics;
	}
	
	public Set<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	
	public Set<ClinicalCenterAdmin> getAdmins() {
		return admins;
	}
	
	public void setAdmins(Set<ClinicalCenterAdmin> admins) {
		this.admins = admins;
	}
	
}
