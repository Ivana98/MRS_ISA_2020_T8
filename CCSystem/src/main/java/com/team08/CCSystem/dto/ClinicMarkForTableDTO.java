package com.team08.CCSystem.dto;

import com.team08.CCSystem.model.ClinicMark;

public class ClinicMarkForTableDTO {

	private Long clinicMark_id;
	private String clinic_name;
	private String clinic_mark;
	
	public ClinicMarkForTableDTO(ClinicMark cm) {
		super();
		this.clinicMark_id = cm.getId();
		this.clinic_name = cm.getClinic().getName();
		this.clinic_mark = cm.getMark()+"";//convert to string.
	}
	
	public ClinicMarkForTableDTO(Long clinicMark_id, String clinic_name,String clinic_mark) {
		super();
		this.clinicMark_id = clinicMark_id;
		this.clinic_name = clinic_name;
		this.clinic_mark = clinic_mark;
	}

	public Long getClinicMark_id() {
		return clinicMark_id;
	}

	public void setClinicMark_id(Long clinicMark_id) {
		this.clinicMark_id = clinicMark_id;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public String getClinic_mark() {
		return clinic_mark;
	}

	public void setClinic_mark(String clinic_mark) {
		this.clinic_mark = clinic_mark;
	}

	@Override
	public String toString() {
		return "clinicMarkForTableDTO [clinicMark_id=" + clinicMark_id + ", clinic_name=" + clinic_name
				+ ", clinic_mark=" + clinic_mark + "]";
	}

	
	
	
}
