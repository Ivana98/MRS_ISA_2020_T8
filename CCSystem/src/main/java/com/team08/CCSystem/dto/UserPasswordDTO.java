package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.User;

public class UserPasswordDTO {
	
	private Long id;
	private String password;
	private String newPassword;
	private String confirmedPassword;
	
	/**
	 * @param id
	 * @param password
	 * @param newPassword
	 * @param confirmedPassword
	 */
	public UserPasswordDTO(Long id, String password, String newPassword, String confirmedPassword) {
		super();
		this.id = id;
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
	
	public UserPasswordDTO(User user) {
		//TODO: check, but I think it's not needed to do this constructor.
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "UserPasswordDTO [id=" + id + ", password=" + password + ", newPassword=" + newPassword
				+ ", confirmedPassword=" + confirmedPassword + "]";
	}
	
}
