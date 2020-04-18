/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.metal.OceanTheme;

import com.team08.CCSystem.model.enums.BloodType;

/**
 * @author Veljko
 *
 */
public class Patient extends User {

	private String policyholder;
	private int height;
	private int weight;
	private BloodType bloodType;
	private String allergy;
	private String diopter;
	private Set<Examination> examinations = new HashSet<>();
	private Set<ClinicMark> marks = new HashSet<>();
}
