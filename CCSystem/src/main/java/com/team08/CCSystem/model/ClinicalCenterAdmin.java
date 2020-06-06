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

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE clinical_center_admin SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "ClinicalCenterAdmin")
public class ClinicalCenterAdmin extends User {
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ClinicalCenter clinicalCenter;
	
	public ClinicalCenterAdmin() {}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 * @param absences
	 * @param clinicalCenter
	 */
	public ClinicalCenterAdmin(Long id, String email, String name, String surname, Address address, String phone,
			String password, Set<Absence> absences, ClinicalCenter clinicalCenter) {
		super(id, email, name, surname, address, phone, password);
		this.absences = absences;
		this.clinicalCenter = clinicalCenter;
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
	public ClinicalCenterAdmin(Long id, String email, String name, String surname, Address address, String phone,
			String password) {
		super(id, email, name, surname, address, phone, password);
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	public ClinicalCenter getClinicalCenter() {
		return clinicalCenter;
	}

	public void setClinicalCenter(ClinicalCenter clinicalCenter) {
		this.clinicalCenter = clinicalCenter;
	}
	
}
