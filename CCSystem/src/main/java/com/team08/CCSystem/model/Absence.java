/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Temporal(TemporalType.DATE)
	@Column(name = "start", nullable = false, unique = false)
	private Date start;
	@Temporal(TemporalType.DATE)
	@Column(name = "end", nullable = false, unique = false)
	private Date end;
	@Enumerated
	private AbsenceType absenceType;
	
	public Absence() {}

	public Absence(Integer id, Date start, Date end, AbsenceType absenceType) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.absenceType = absenceType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}
	
	
}
