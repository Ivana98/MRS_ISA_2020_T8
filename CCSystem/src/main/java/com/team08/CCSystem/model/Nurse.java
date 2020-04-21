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
@Table(name = "Nurse")
public class Nurse extends User {
	
	@OneToMany(mappedBy = "Doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;  // clinic to which nurse belongs
	
	public Nurse() {
		super();
	}

	public Nurse(Set<Absence> absences, Clinic clinic) {
		super();
		this.absences = absences;
		this.clinic = clinic;
	}

	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}
	
}
