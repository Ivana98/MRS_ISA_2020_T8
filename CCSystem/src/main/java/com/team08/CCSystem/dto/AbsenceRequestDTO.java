/**
 * 
 */
package com.team08.CCSystem.dto;

/**
 * @author Veljko
 *
 */
public class AbsenceRequestDTO {
	
	
	private Long id;
	private String description;
	
	/**
	 * @param id
	 * @param desscription
	 */
	public AbsenceRequestDTO(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	/**
	 * 
	 */
	public AbsenceRequestDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desscription) {
		this.description = desscription;
	}

	@Override
	public String toString() {
		return "AbsenceRequestDTO [id=" + id + ", desscription=" + description + "]";
	}

}
