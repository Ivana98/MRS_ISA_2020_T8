package com.team08.CCSystem.dto;

import java.util.HashSet;
import java.util.Set;

import com.team08.CCSystem.model.ClinicMark;
import com.team08.CCSystem.model.DoctorMark;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.Patient;

public class PatienForNursetDTO {
	//Atributi pacijenta.
	private Long id;
	private String policyholder;
	private int height;
	private int weight;
	private String bloodType;
	private String allergy;
	private String diopter;
//	private String clinicalCenter_id;
	private String clinicalCenter_name;
	private String email;
	private String name;
	private String surname;
	private String city;
	private String country;
	private String street;
	private String phone;
	//private String password;
	
	private Set<ClinicMarkForTableDTO> clinicMark = new HashSet<ClinicMarkForTableDTO>();
	
	private Set<DoctorMarkForTableDTO> doctorMark = new HashSet<DoctorMarkForTableDTO>();
	
	private Set<ExaminationForNurseDTO> examinations = new HashSet<ExaminationForNurseDTO>();

	
	public PatienForNursetDTO(Patient p) {
		super();
		this.id = p.getId();
		this.policyholder = p.getPolicyholder();
		this.height = p.getHeight();
		this.weight = p.getWeight();
		this.bloodType = p.getBloodType()+ "";
		this.allergy = p.getAllergy();
		this.diopter = p.getDiopter();
		this.clinicalCenter_name = p.getClinicalCenter().getName();
		this.email = p.getEmail();
		this.name = p.getName();
		this.surname = p.getSurname();
		this.city = p.getAddress().getCity();
		this.street = p.getAddress().getStreet();
		this.country = p.getAddress().getCountry();
		this.phone = p.getPhone();
		convertClinicMark(p.getClinicsMarks());
		convertDoctorMark(p.getDoctorsMarks());
		convertExaminations(p.getExaminations());
	}

	public PatienForNursetDTO(Long id, String policyholder, int height, int weight, String bloodType, String allergy,
			String diopter, String clinicalCenter_name, String email, String name, String surname, String city,
			String country, String street, String phone, Set<ClinicMarkForTableDTO> clinicMark,
			Set<DoctorMarkForTableDTO> doctorMark, Set<ExaminationForNurseDTO> examinations) {
		super();
		this.id = id;
		this.policyholder = policyholder;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.allergy = allergy;
		this.diopter = diopter;
		this.clinicalCenter_name = clinicalCenter_name;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.country = country;
		this.street = street;
		this.phone = phone;
		this.clinicMark = clinicMark;
		this.doctorMark = doctorMark;
		this.examinations = examinations;
	}


	
	public void convertClinicMark(Set<ClinicMark> cm) {
		System.out.println("PAPA");
		Set<ClinicMarkForTableDTO> clinicMark2 = this.getClinicMark();
		for(ClinicMark c : cm) {
			System.out.println(c.getMark() + " OCENAAA");
			ClinicMarkForTableDTO clm = new ClinicMarkForTableDTO(c); 
			System.out.println(clm.getClinic_mark() + " hahaha");
			System.out.println("PRICEE");
			clinicMark2.add(clm);
			System.out.println("JUPIIII");
		}
		this.setClinicMark(clinicMark2);
		System.out.println("Pa stiga sam!");
	}
	
	public void convertDoctorMark(Set<DoctorMark> dm) {
		for(DoctorMark d : dm) {
			DoctorMarkForTableDTO doc = new DoctorMarkForTableDTO(d); 
			this.getDoctorMark().add(doc);
		}
	}
	
	public void convertExaminations(Set<Examination> exm) {
		for(Examination e : exm) {
			ExaminationForNurseDTO ex = new ExaminationForNurseDTO(e); 
			this.getExaminations().add(ex);
		}
	}
	
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyholder() {
		return policyholder;
	}

	public void setPolicyholder(String policyholder) {
		this.policyholder = policyholder;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getDiopter() {
		return diopter;
	}

	public void setDiopter(String diopter) {
		this.diopter = diopter;
	}

	public String getClinicalCenter_name() {
		return clinicalCenter_name;
	}

	public void setClinicalCenter_name(String clinicalCenter_name) {
		this.clinicalCenter_name = clinicalCenter_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<ClinicMarkForTableDTO> getClinicMark() {
		return clinicMark;
	}

	public void setClinicMark(Set<ClinicMarkForTableDTO> clinicMark) {
		this.clinicMark = clinicMark;
	}

	public Set<DoctorMarkForTableDTO> getDoctorMark() {
		return doctorMark;
	}

	public void setDoctorMark(Set<DoctorMarkForTableDTO> doctorMark) {
		this.doctorMark = doctorMark;
	}

	public Set<ExaminationForNurseDTO> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<ExaminationForNurseDTO> examinations) {
		this.examinations = examinations;
	}

	@Override
	public String toString() {
		return "PatienForNursetDTO [id=" + id + ", policyholder=" + policyholder + ", height=" + height + ", weight="
				+ weight + ", bloodType=" + bloodType + ", allergy=" + allergy + ", diopter=" + diopter
				+ ", clinicalCenter_name=" + clinicalCenter_name + ", email=" + email + ", name=" + name + ", surname="
				+ surname + ", city=" + city + ", country=" + country + ", street=" + street + ", phone=" + phone
				+ ", clinicMark=" + clinicMark + ", doctorMark=" + doctorMark + ", examinations=" + examinations + "]";
	}
	
	
}
