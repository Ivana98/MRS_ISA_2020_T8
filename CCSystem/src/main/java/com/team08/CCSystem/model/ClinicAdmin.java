/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE clinic_admin SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "ClinicAdmin")
public class ClinicAdmin extends User {

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;
	
	@Column(name = "isPasswordChanged", nullable = false)
	private boolean isPasswordChanged;
	
	public ClinicAdmin() {}

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
		this.isPasswordChanged = false;
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
		this.isPasswordChanged = false;
	}

	public boolean isPasswordChanged() {
		return isPasswordChanged;
	}

	public void setPasswordChanged(boolean isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
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
