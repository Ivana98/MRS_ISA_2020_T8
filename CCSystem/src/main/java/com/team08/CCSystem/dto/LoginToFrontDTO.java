package com.team08.CCSystem.dto;

public class LoginToFrontDTO {
	private String responseStatus;
	private String userRole;
	
	public LoginToFrontDTO() {}
	
	public LoginToFrontDTO(String responseStatus, String userRole) {
		super();
		this.responseStatus = responseStatus;
		this.userRole = userRole;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	

}
