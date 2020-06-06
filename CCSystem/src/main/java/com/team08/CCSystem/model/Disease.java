/**
 * 
 */
package com.team08.CCSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Entity
@SQLDelete(sql = "UPDATE disease SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Data
@Table(name = "Disease")
public class Disease {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "examinationing", joinColumns = @JoinColumn(name = "disease_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"))
	private Set<Examination> examinations = new HashSet<Examination>();
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param examinations
	 */
	public Disease(Long id, String name, String description, HashSet<Examination> examinations) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.examinations = examinations;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public Disease() {
		super();
		this.deleted = false;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}
	
}
