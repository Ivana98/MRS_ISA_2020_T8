/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Veljko
 *
 */
@Entity
@Table(name = "ClinicalCenterAdmin")
public class ClinicalCenterAdmin extends User {
	
	@OneToMany(mappedBy = "ClinicalCenterAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ClinicalCentre clinicalCenter;
	
	public ClinicalCenterAdmin() {
		super();
	}

	public ClinicalCenterAdmin(Set<Absence> absences, ClinicalCentre clinicalCenter) {
		super();
		this.absences = absences;
		this.clinicalCenter = clinicalCenter;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	public ClinicalCentre getClinicalCenter() {
		return clinicalCenter;
	}
	
	public void setClinicalCenter(ClinicalCentre clinicalCenter) {
		this.clinicalCenter = clinicalCenter;
	}
	
	
}
