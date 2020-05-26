/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

/**
 * @author Veljko
 *
 */
public class StartEndDateDTO {
	
	public Date startDate;
	public Date endDate;
	
	/**
	 * @param startDate is start time of examination
	 * @param endDate is end time of examination
	 */
	public StartEndDateDTO(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * 
	 */
	public StartEndDateDTO() {
		super();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "StartEndDateDTO [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
