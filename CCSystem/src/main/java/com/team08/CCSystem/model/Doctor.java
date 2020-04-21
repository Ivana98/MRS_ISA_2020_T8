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

/**
 * @author Veljko
 *
 */
@Entity
@Table(name = "Doctor")
public class Doctor extends User {


	@OneToMany(mappedBy = "Doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Absence> absences = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;  // clinic to which doctor belongs
	@Enumerated
	private Specialisation specialisation;
	@OneToMany(mappedBy = "Doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Examination> examinations = new HashSet<>();
	@OneToMany(mappedBy = "Doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DoctorMark> marks = new HashSet<>();
	@Column(name="averageMark", unique=false, nullable=false)
	private float averageMark;
	
	public Doctor() {
		super();
	}

	public Doctor(Set<Absence> absences, Clinic clinic, Specialisation specialisation, Set<Examination> examinations,
			Set<DoctorMark> marks, float averageMark) {
		super();
		this.absences = absences;
		this.clinic = clinic;
		this.specialisation = specialisation;
		this.examinations = examinations;
		this.marks = marks;
		this.averageMark = averageMark;
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
