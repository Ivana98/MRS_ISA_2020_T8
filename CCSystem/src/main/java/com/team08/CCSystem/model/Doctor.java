/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import com.team08.CCSystem.model.enums.Specialisation;

/**
 * @author Veljko
 *
 */
public class Doctor extends User {

	private Integer id;
	private Absence absence;
	private Clinic clinic;  // clinic to which the doctor belongs
	private Specialisation specialisation;
	private Set<Examination> examinations;
	private Set<DoctorMark> marks = new HashSet<>();
	private float averageMark;
}
