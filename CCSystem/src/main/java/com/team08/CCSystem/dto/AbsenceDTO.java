/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.Date;

import com.team08.CCSystem.model.Absence;

/**
 * @author Veljko
 *
 */
public class AbsenceDTO {
	
	private Long id;
	private Date beginDate;
	private Date endDate;
	private String absenceType;
	private boolean confirmed;
	private Long userId;
	
	/**
	 * @param id
	 * @param beginDate
	 * @param endDate
	 * @param absenceType
	 * @param userId
	 */
	public AbsenceDTO(Long id, Date beginDate, Date endDate, String absenceType, Long userId) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.absenceType = absenceType;
		this.userId = userId;
	}
	
	/**
	 * 
	 */
	public AbsenceDTO() {
		super();
	}
	
	/**
	 * @param absence
	 */
	public AbsenceDTO(Absence absence) {
		super();
		this.id = absence.getId();
		this.beginDate = absence.getStartDate();
		this.endDate = absence.getEndDate();
		this.absenceType = absence.getAbsenceType().name();
		this.userId = absence.getUser().getId();
		this.confirmed = absence.isConfirmed();
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(String absenceType) {
		this.absenceType = absenceType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AbsenceDTO [id=" + id + ", beginDate=" + beginDate + ", endDate=" + endDate + ", absenceType="
				+ absenceType + ", confirmed=" + confirmed + ", userId=" + userId + "]";
	}

}
