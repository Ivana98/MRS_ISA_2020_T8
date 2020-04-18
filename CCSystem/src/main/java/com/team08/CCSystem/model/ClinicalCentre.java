package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

public class ClinicalCentre {
	
	private Integer id;
	private String name;
	private Set<Clinic> clinics = new HashSet<Clinic>();
	private Set<Patient> patients = new HashSet<>();
	private Set<ClinicalCenterAdmin> admins = new HashSet<>();
}
