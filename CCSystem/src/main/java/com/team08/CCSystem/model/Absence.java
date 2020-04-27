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

import com.team08.CCSystem.model.enums.AbsenceType;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@Data
@Table(name = "Absence")
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
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

	/**
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param absenceType
	 */
	public Absence(Integer id, Date startDate, Date endDate, AbsenceType absenceType) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.absenceType = absenceType;
	}

	/**
	 * 
	 */
	public Absence() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getstartDate() {
		return startDate;
	}

	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getendDate() {
		return endDate;
	}

	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}
	
}
