package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.DoctorMark;

public class DoctorMarkForTableDTO {
	
	private String doctorMark_id;
	private String doctorMark_name;
	private String doctorMark_surname;
	private String doctorMark_email;
	private String dotcotMark_mark;
	
	

	public DoctorMarkForTableDTO(DoctorMark doctorMark) {
		super();
		this.doctorMark_id = doctorMark.getId() + "";
		this.doctorMark_name = doctorMark.getDoctor().getName();
		this.doctorMark_surname = doctorMark.getDoctor().getSurname();
		this.doctorMark_email = doctorMark.getDoctor().getEmail();
		this.dotcotMark_mark = doctorMark.getMark() + "";
	}
	
	
	public DoctorMarkForTableDTO(String doctorMark_id, String doctorMark_name, String doctorMark_surname,
			String doctorMark_email, String dotcotMark_mark) {
		super();
		this.doctorMark_id = doctorMark_id;
		this.doctorMark_name = doctorMark_name;
		this.doctorMark_surname = doctorMark_surname;
		this.doctorMark_email = doctorMark_email;
		this.dotcotMark_mark = dotcotMark_mark;
	}
	
	
	public String getDoctorMark_id() {
		return doctorMark_id;
	}
	public void setDoctorMark_id(String doctorMark_id) {
		this.doctorMark_id = doctorMark_id;
	}
	public String getDoctorMark_name() {
		return doctorMark_name;
	}
	public void setDoctorMark_name(String doctorMark_name) {
		this.doctorMark_name = doctorMark_name;
	}
	public String getDoctorMark_surname() {
		return doctorMark_surname;
	}
	public void setDoctorMark_surname(String doctorMark_surname) {
		this.doctorMark_surname = doctorMark_surname;
	}
	public String getDoctorMark_email() {
		return doctorMark_email;
	}
	public void setDoctorMark_email(String doctorMark_email) {
		this.doctorMark_email = doctorMark_email;
	}
	public String getDotcotMark_mark() {
		return dotcotMark_mark;
	}
	public void setDotcotMark_mark(String dotcotMark_mark) {
		this.dotcotMark_mark = dotcotMark_mark;
	}
	@Override
	public String toString() {
		return "DoctorMarkForTableDTO [doctorMark_id=" + doctorMark_id + ", doctorMark_name=" + doctorMark_name
				+ ", doctorMark_surname=" + doctorMark_surname + ", doctorMark_email=" + doctorMark_email
				+ ", dotcotMark_mark=" + dotcotMark_mark + "]";
	}
	
	
	
}
