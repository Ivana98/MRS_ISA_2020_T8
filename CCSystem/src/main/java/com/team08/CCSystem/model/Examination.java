/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Veljko
 *
 */
public class Examination {
	
	private Integer id;
	private Date date;
	private boolean wasOnExamination;
	private String description;
	private float discount;
	private ExaminationType examinationType;
	private Prescription prescription;
	private Set<Disease> disease = new HashSet<>();
	private MedicalRoom medicalRoom;
	private Doctor doctor;
}
