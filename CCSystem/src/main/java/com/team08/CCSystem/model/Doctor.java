/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.team08.CCSystem.model.enums.Specialisation;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "Doctor")
public class Doctor extends User {

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Clinic clinic;  // clinic to which doctor belongs
	
	@Enumerated
	private Specialisation specialisation;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Examination> examinations = new HashSet<>();
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DoctorMark> marks = new HashSet<>();
	
	@Column(name="averageMark")
	private float averageMark;
	
	public Doctor() {}

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
	 * @param specialisation
	 * @param examinations
	 * @param marks
	 * @param averageMark
	 */
	public Doctor(Long id, String email, String name, String surname, Address address, String phone, String password,
			Set<Absence> absences, Clinic clinic, Specialisation specialisation, Set<Examination> examinations,
			Set<DoctorMark> marks, float averageMark) {
		super(id, email, name, surname, address, phone, password);
		this.absences = absences;
		this.clinic = clinic;
		this.specialisation = specialisation;
		this.examinations = examinations;
		this.marks = marks;
		this.averageMark = averageMark;
	}
	
	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 * @param clinic
	 * @param specialisation
	 * @param averageMark
	 */
	public Doctor(Long id, String email, String name, String surname, Address address, String phone, String password,
			Clinic clinic, Specialisation specialisation, float averageMark) {
		super(id, email, name, surname, address, phone, password);
		this.clinic = clinic;
		this.specialisation = specialisation;
		this.averageMark = averageMark;
	}



	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param surname
	 * @param address
	 * @param phone
	 * @param password
	 */
	public Doctor(Long id, String email, String name, String surname, Address address, String phone,
			String password) {
		super(id, email, name, surname, address, phone, password);
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

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}

	public Set<DoctorMark> getMarks() {
		return marks;
	}

	public void setMarks(Set<DoctorMark> marks) {
		this.marks = marks;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

}
