/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.Clinic;

/**
 * @author Veljko
 *
 * Send this object to client. Then client choose 
 * the name of clinic, and return some other 
 * with id of chosen clinic.
 * 
 */
public class ClinicBasicDTO {
	private Long id;
	private String name;
	
	/**
	 * 
	 */
	public ClinicBasicDTO() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public ClinicBasicDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @param c is Clinic
	 */
	public ClinicBasicDTO(Clinic c) {
		this.id = c.getId();
		this.name = c.getName();
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
	
	@Override
	public String toString() {
		return "ClinicBasicDTO [id=" + id + ", name=" + name + "]";
	}
	
}