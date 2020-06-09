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
public class AbsenceUserDTO {
	
	private Long id;
	private Date beginDate;
	private Date endDate;
	private String absenceType;
	private Boolean confirmed;
	private Long userId;
	
	// new in relation to AbsenceDTO
	private String firstName;
	private String lastName;
	private String email;
	
	/**
	 * @param id
	 * @param beginDate
	 * @param endDate
	 * @param absenceType
	 * @param confirmed
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public AbsenceUserDTO(Long id, Date beginDate, Date endDate, String absenceType, Boolean confirmed, Long userId,
			String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.absenceType = absenceType;
		this.confirmed = confirmed;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * 
	 */
	public AbsenceUserDTO() {
		super();
	}
	
	/**
	 * @param absence
	 */
	public AbsenceUserDTO(Absence absence) {
		super();
		this.id = absence.getId();
		this.beginDate = absence.getStartDate();
		this.endDate = absence.getStartDate();
		this.absenceType = absence.getAbsenceType().name();
		this.confirmed = absence.isConfirmed();
		this.userId = absence.getUser().getId();
		this.firstName = absence.getUser().getName();
		this.lastName = absence.getUser().getSurname();
		this.email = absence.getUser().getEmail();
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

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbsenceUserDTO [id=" + id + ", beginDate=" + beginDate + ", endDate=" + endDate + ", absenceType="
				+ absenceType + ", confirmed=" + confirmed + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
