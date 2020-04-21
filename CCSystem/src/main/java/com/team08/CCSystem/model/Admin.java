package com.team08.CCSystem.model;

public class Admin {
	private String ime;
	private String password;
	
	
	
	public Admin(String name , String pass) {
		this.setName(name);
		this.setPassword(pass);
	}
	public String getName() {
		return ime;
	}
	public void setName(String ime) {
		this.ime = ime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Ime : " + this.getName() + " ,password : " + this.getPassword();  
	}
}
