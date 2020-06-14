package com.team08.CCSystem.dto;

import java.util.Date;

public class FilterClinicsDTO {
	
	private String specialisation;
    private Date searchedDate; //with time
    
    public FilterClinicsDTO() {}
    
	public FilterClinicsDTO(String specialisation, Date searchedDate) {
		super();
		this.specialisation = specialisation;
		this.searchedDate = searchedDate;
	}
	
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public Date getSearchedDate() {
		return searchedDate;
	}
	public void setSearchedDate(Date searchedDate) {
		this.searchedDate = searchedDate;
	}
	
}
