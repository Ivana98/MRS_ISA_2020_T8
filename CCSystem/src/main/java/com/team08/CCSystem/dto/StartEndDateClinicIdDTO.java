/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

/**
 * @author Veljko
 *
 */
public class StartEndDateClinicIdDTO {
	
	private Date startDate;
	private Date endDate;
	private Long clinicId;
	
	/**
	 * @param startDate
	 * @param endDate
	 * @param clinicId
	 */
	public StartEndDateClinicIdDTO(Date startDate, Date endDate, Long clinicId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.clinicId = clinicId;
	}

	/**
	 * 
	 */
	public StartEndDateClinicIdDTO() {
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

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	@Override
	public String toString() {
		return "StartEndDateClinicId [startDate=" + startDate + ", endDate=" + endDate + ", clinicId=" + clinicId + "]";
	}
	
}
