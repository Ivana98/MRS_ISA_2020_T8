/**
 * 
 */
package com.team08.CCSystem.dto;

/**
 * @author Veljko
 *
 */
public class MedicalRoomDTO {
	
	private Long id;
	private String number;
	private String inversionType;
	
	/**
	 * @param id
	 * @param number
	 * @param inversionType
	 */
	public MedicalRoomDTO(Long id, String number, String inversionType) {
		super();
		this.id = id;
		this.number = number;
		this.inversionType = inversionType;
	}
	
	/**
	 * Empty constructor
	 */
	public MedicalRoomDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getnumber() {
		return number;
	}
	
	public void setnumber(String number) {
		this.number = number;
	}
	
	public String getInversionType() {
		return inversionType;
	}
	
	public void setInversionType(String inversionType) {
		this.inversionType = inversionType;
	}
	
	@Override
	public String toString() {
		return "MedicalRoomDTO [id=" + id + ", number=" + number + ", inversionType=" + inversionType + "]";
	}
	
}
