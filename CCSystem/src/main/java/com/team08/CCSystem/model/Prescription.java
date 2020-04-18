/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.Date;

/**
 * @author Veljko
 *
 */
public class Prescription {

	private Integer id;
	private boolean validated;
	private int quantity;
	private Date expirationDate; //expiration date of prescription
	private Nurse nurse;
	private Medication medication;
	private String description;
}
