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
@Table(name = "ClinicalCenter")
public class ClinicalCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "clinicalCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Clinic> clinics = new HashSet<Clinic>();
	
	@OneToMany(mappedBy = "clinicalCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patient> patients = new HashSet<>();
	
	@OneToMany(mappedBy = "clinicalCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicalCenterAdmin> admins = new HashSet<>();
}
