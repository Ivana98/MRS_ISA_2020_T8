package com.team08.CCSystem.dto;

public class ClinicRegistrationDTO {
		private Long id;
		private String name;
		private String country;
		private String city;
		private String street;
		private String clinicalCenter_id;
		
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
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getClinicalCenter_id() {
			return clinicalCenter_id;
		}
		public void setClinicalCenter_id(String clinicalCenter_id) {
			this.clinicalCenter_id = clinicalCenter_id;
		}
		@Override
		public String toString() {
			return "ClinicRegistrationDTO [id=" + id + ", name=" + name + ", country=" + country + ", city=" + city
					+ ", street=" + street + ", clinicalCenter_id=" + clinicalCenter_id + "]";
		}
		
}
