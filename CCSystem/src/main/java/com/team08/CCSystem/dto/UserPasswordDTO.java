package com.team08.CCSystem.dto;

public class UserPasswordDTO {
	private String previousPassword;
	private String newPassword;
	private String confirmedPassword;
	
	public UserPasswordDTO() {}
	
	public UserPasswordDTO(String previousPassword, String newPassword, String confirmedPassword) {
		super();
		this.previousPassword = previousPassword;
		this.newPassword = newPassword;
		this.confirmedPassword = confirmedPassword;
	}

	public String getPreviousPassword() {
		return previousPassword;
	}

	public void setPreviousPassword(String previousPassword) {
		this.previousPassword = previousPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	

}
