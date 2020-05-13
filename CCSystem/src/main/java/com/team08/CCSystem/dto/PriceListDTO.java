/**
 * 
 */
package com.team08.CCSystem.dto;

/**
 * @author Veljko
 *
 */
public class PriceListDTO {
	
	private Long id;
	private double price;
	private Long examination_type_id;
	
	/**
	 * @param id
	 * @param price
	 * @param duration
	 * @param interventionType
	 * @param specialisation
	 */
	public PriceListDTO(Long id, double price, Long examination_type_id) {
		super();
		this.id = id;
		this.price = price;
		this.examination_type_id = examination_type_id;
	}

	/**
	 * 
	 */
	public PriceListDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getExamination_type_id() {
		return examination_type_id;
	}

	public void setExamination_type_id(Long examination_type_id) {
		this.examination_type_id = examination_type_id;
	}

	@Override
	public String toString() {
		return "PriceListDTO [id=" + id + ", price=" + price + ", examination_type_id=" + examination_type_id + "]";
	}

}
