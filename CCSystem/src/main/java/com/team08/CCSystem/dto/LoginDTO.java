package com.team08.CCSystem.dto;

//DTO which  collect data from login form
public class LoginDTO {
	private String username;
	private String password;
	
	public LoginDTO() {
        super();
    }

    public LoginDTO(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
