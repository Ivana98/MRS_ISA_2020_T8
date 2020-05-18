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

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "ClinicAdmin")
public class ClinicAdmin extends User {

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 * @param absences
	 * @param clinic
	 */
	public ClinicAdmin(Long id, String email, String name, String surname, Address address, String phone,
			String password, Set<Absence> absences, Clinic clinic) {
		super(id, email, name, surname, address, phone, password);
		this.absences = absences;
		this.clinic = clinic;
	}
	
	/**
	 * Empty constructor
	 * 
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 */
	public ClinicAdmin(Long id, String email, String name, String surname, Address address, String phone,
			String password) {
		super(id, email, name, surname, address, phone, password);
	}
	
	public ClinicAdmin() {
		
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
