package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.User;

public class UserPasswordDTO {
	
	private String password;
	private String newPassword;
	private String confirmedPassword;
	
	/**
	 * @param id
	 * @param password
	 * @param newPassword
	 * @param confirmedPassword
	 */
	public UserPasswordDTO(String password, String newPassword, String confirmedPassword) {
		super();
		this.password = password;
		this.newPassword = newPassword;
		this.confirmedPassword = confirmedPassword;
	}
	
	/**
	 * 
	 */
	public UserPasswordDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "UserPasswordDTO [  password=" + password + ", newPassword=" + newPassword
				+ ", confirmedPassword=" + confirmedPassword + "]";
	}
	
}
