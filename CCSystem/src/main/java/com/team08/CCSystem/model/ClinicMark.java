/**
 * 
 */
package com.team08.CCSystem.model;

/**
 * @author Veljko
 *
 * Patients give marks to clinic
 */
public class ClinicMark {
	
	private Integer id;
	private float mark; //from 0 to 5
	private Patient patient;
	private Clinic clinic;
}
