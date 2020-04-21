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
@Table(name = "ClinicAdmin")
public class ClinicAdmin extends User {

	@OneToMany(mappedBy = "ClinicAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;
	
	public ClinicAdmin() {
		super();
	}

	public ClinicAdmin(Set<Absence> absences, Clinic clinic) {
		super();
		this.absences = absences;
		this.clinic = clinic;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	public Clinic getClinic() {
		return clinic;
	}
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	
}
