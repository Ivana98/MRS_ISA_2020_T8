package com.team08.CCSystem.dto;

public class UserPasswordDTO {
	private String password;
	private String newPassword;
	private String confirmedPassword;
	
	public UserPasswordDTO() {}
	
	public UserPasswordDTO(String previousPassword, String newPassword, String confirmedPassword) {
		super();
		this.password = previousPassword;
		this.newPassword = newPassword;
		this.confirmedPassword = confirmedPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String previousPassword) {
		this.password = previousPassword;
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

	@Override
	public String toString() {
		return "UserPasswordDTO [previousPassword=" + password + ", newPassword=" + newPassword
				+ ", confirmedPassword=" + confirmedPassword + "]";
	}
	

}
