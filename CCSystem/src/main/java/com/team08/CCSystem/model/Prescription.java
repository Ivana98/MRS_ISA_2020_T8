/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Data
@Entity
@Table(name = "Prescription")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "validated", nullable = false, unique = false)
	private boolean validated;
	
	@Column(name = "quantity", nullable = false, unique = false)
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expirationDate", nullable = false, unique = false)
	private Date expirationDate; //expiration date of prescription
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Nurse nurse;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Medication medication;
	
	@Column(name = "description", nullable = false, unique = false)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "prescriptioning", joinColumns = @JoinColumn(name = "prescription_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"))
	private Set<Examination> examinations = new HashSet<Examination>();
	
	
}
