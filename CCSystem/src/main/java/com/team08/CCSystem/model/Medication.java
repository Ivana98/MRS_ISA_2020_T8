/**
 * 
 */
package com.team08.CCSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author Veljko
 *
 */
@Data
@SQLDelete(sql = "UPDATE medication SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
@Entity
@Table(name = "Medication")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(nullable = false)
	private Boolean deleted;

	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Medication(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.deleted = false;
	}

	/**
	 * 
	 */
	public Medication() {
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
	
}
