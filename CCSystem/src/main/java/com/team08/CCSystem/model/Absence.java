/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.team08.CCSystem.model.enums.AbsenceType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE absence SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "Absence")
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDate", nullable = false)
	private Date endDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	
	@Enumerated
	private AbsenceType absenceType;
	
	@Column(name = "confirmed", nullable = true)
	private Boolean confirmed;
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param absenceType
	 */
	public Absence(Long id, Date startDate, Date endDate, User user, AbsenceType absenceType) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.absenceType = absenceType;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public Absence() {
		super();
		this.deleted = false;
	}

	public Boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}
	
}
