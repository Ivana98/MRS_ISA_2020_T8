/**
 * 
 */
package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.User;

/**
 * @author Veljko
 *
 */
public class SpecificUserProfileDTO {

	private Long id;
	
	public SpecificUserProfileDTO() {
		
	}
	
	public SpecificUserProfileDTO(User user) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
