package com.team08.CCSystem.dto;

/*
 * class used for transferring pair of clinic/doctor id 
 * and mark for clinic/doctor which is given by patient
 */
public class SaveMarkDTO {
	
	private Long id; 
	private float mark;
	
	public SaveMarkDTO() {}
	
	public SaveMarkDTO(Long id, float mark) {
		super();
		this.id = id;
		this.mark = mark;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}

}
