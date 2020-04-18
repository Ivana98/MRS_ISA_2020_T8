/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Veljko
 *
 */
public class Clinic {
	
	private Integer id;
	private String name;
	private Address address;
	private ClinicalCentre clinicalCenter;
	private Set<MedicalRoom> rooms = new HashSet<>();
	private Set<ClinicMark> marks = new HashSet<>();
	private Set<Doctor> doctors = new HashSet<>();
	private Set<Nurse> nurses = new HashSet<>();
	private Set<ClinicAdmin> admins = new HashSet<>();
	private float averageMark;
}
