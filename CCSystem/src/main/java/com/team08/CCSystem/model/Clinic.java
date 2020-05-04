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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Clinic")
public class Clinic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ClinicalCenter clinicalCenter;
	
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MedicalRoom> rooms = new HashSet<>();
	
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicMark> marks = new HashSet<>();
	
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Doctor> doctors = new HashSet<>();
	
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Nurse> nurses = new HashSet<>();
	
	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicAdmin> admins = new HashSet<>();
	
	@Column(name = "averageMark", nullable = false, unique = false)
	private float averageMark;

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param clinicalCenter
	 * @param rooms
	 * @param marks
	 * @param doctors
	 * @param nurses
	 * @param admins
	 * @param averageMark
	 */
	public Clinic(Long id, String name, Address address, ClinicalCenter clinicalCenter, Set<MedicalRoom> rooms,
			Set<ClinicMark> marks, Set<Doctor> doctors, Set<Nurse> nurses, Set<ClinicAdmin> admins, float averageMark) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.clinicalCenter = clinicalCenter;
		this.rooms = rooms;
		this.marks = marks;
		this.doctors = doctors;
		this.nurses = nurses;
		this.admins = admins;
		this.averageMark = averageMark;
	}

	/**
	 * 
	 */
	public Clinic() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ClinicalCenter getClinicalCenter() {
		return clinicalCenter;
	}

	public void setClinicalCenter(ClinicalCenter clinicalCenter) {
		this.clinicalCenter = clinicalCenter;
	}

	public Set<MedicalRoom> getRooms() {
		return rooms;
	}

	public void setRooms(Set<MedicalRoom> rooms) {
		this.rooms = rooms;
	}

	public Set<ClinicMark> getMarks() {
		return marks;
	}

	public void setMarks(Set<ClinicMark> marks) {
		this.marks = marks;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Set<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(Set<Nurse> nurses) {
		this.nurses = nurses;
	}

	public Set<ClinicAdmin> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<ClinicAdmin> admins) {
		this.admins = admins;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

	@Override
	public String toString() {
		return "Clinic [id=" + id + ", name=" + name + ", address=" + address
				+ ", rooms=" + rooms + ", marks=" + marks + ", averageMark=" + averageMark + "]";
	}
	
}
