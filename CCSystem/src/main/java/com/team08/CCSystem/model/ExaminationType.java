/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "ExaminationType")
public class ExaminationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "price", nullable = false, unique = false)
	private double price;
	
	@Column(name = "duration", nullable = false, unique = false)
	private int duration;
	
	@Enumerated
	private InterventionType interventionType;
	
	@Enumerated
	private Specialisation specialisation;
}
