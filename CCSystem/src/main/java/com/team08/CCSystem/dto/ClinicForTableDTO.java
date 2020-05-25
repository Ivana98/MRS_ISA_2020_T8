package com.team08.CCSystem.dto;

import java.util.Set;

public class ClinicForTableDTO {
	private Long id;
	private String name;
	private String addressStreet; //how to share whole adress, is it needed
	private String addressCity;
	private double averageMark;
	private Set<DoctorForClinicListDTO> doctors;
	
	public ClinicForTableDTO() {
		super();
	}
	
	public ClinicForTableDTO(Long id, String name, String addressStreet, String addressCity, double averageMark,
			Set<DoctorForClinicListDTO> doctors) {
		super();
		this.id = id;
		this.name = name;
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.averageMark = averageMark;
		this.doctors = doctors;
	}
	
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public Set<DoctorForClinicListDTO> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<DoctorForClinicListDTO> doctors) {
		this.doctors = doctors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long	 id) {
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
	public String getAdressCity() {
		return addressCity;
	}
	public void setAdressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	
}
