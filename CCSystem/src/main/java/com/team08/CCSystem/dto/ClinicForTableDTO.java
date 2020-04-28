package com.team08.CCSystem.dto;

public class ClinicForTableDTO {
	private Integer id;
	private String name;
	private String addressStreet; //how to share whole adress, is it needed
	private double averageMark;
	
	public ClinicForTableDTO() {
		super();
	}
	
	public ClinicForTableDTO(Integer id, String name, String addressStreet, double averageMark) {
		super();
		this.id = id;
		this.name = name;
		this.addressStreet = addressStreet;
		this.averageMark = averageMark;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public double getAverageMark() {
		return averageMark;
	}
	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}
	
	
}
