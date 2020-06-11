/**
 * 
 */
package com.team08.CCSystem.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.team08.CCSystem.model.Disease;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.Prescription;

/**
 * @author Veljko
 *
 */
public class MedicalRecordExaminationDTO {
	
	private Long id;
	private Date date;
	private String specialisation;
	private String interventionType;
	private double staticPrice;
	private String doctorName;
	private String doctorSurname;
	private String roomNumber;
	private boolean wasOnExamination;
	private List<DiseaseMREDTO> diseases;
	private List<PrescriptionMREDTO> prescriptions;
	
	/**
	 * @param id
	 * @param date
	 * @param specialisation
	 * @param interventionType
	 * @param staticPrice
	 * @param doctorName
	 * @param doctorSurname
	 * @param roomNumber
	 * @param diseases
	 * @param prescriptions
	 */
	public MedicalRecordExaminationDTO(Long id, Date date, String specialisation, String interventionType,
			double staticPrice, String doctorName, String doctorSurname, String roomNumber, boolean wasOnExamination,
			List<DiseaseMREDTO> diseases, List<PrescriptionMREDTO> prescriptions) {
		super();
		this.id = id;
		this.date = date;
		this.specialisation = specialisation;
		this.interventionType = interventionType;
		this.staticPrice = staticPrice;
		this.doctorName = doctorName;
		this.doctorSurname = doctorSurname;
		this.roomNumber = roomNumber;
		this.wasOnExamination = wasOnExamination;
		this.diseases = diseases;
		this.prescriptions = prescriptions;
	}

	/**
	 * 
	 */
	public MedicalRecordExaminationDTO() {
		super();
	}

	/**
	 * @param examination
	 */
	public MedicalRecordExaminationDTO(Examination examination) {
		this.id = examination.getId();
		this.date = examination.getDate();
		this.specialisation = examination.getPrice().getExaminationType().getSpecialisation().name();
		this.interventionType = examination.getPrice().getExaminationType().getInterventionType().name();
		this.staticPrice = examination.getStaticPrice();
		this.doctorName = examination.getDoctor().getName();
		this.doctorSurname = examination.getDoctor().getSurname();
		this.roomNumber = examination.getMedicalRoom().getRoomNumber();
		this.wasOnExamination = examination.getWasOnExamination();
		this.diseases = createDiseaseDTOList(examination.getDiseases());
		this.prescriptions = createPrescriptionsDTOList(examination.getPrescriptions());
	}

	/**
	 * @param prescriptions2
	 * @return
	 */
	private List<PrescriptionMREDTO> createPrescriptionsDTOList(Set<Prescription> prescriptions2) {

		List<PrescriptionMREDTO> prescriptionsMREDTO = new ArrayList<>();
		
		for (Prescription prescription : prescriptions2) {
			prescriptionsMREDTO.add(new PrescriptionMREDTO(prescription));
		}
		
		return prescriptionsMREDTO;
	}

	/**
	 * @param diseases2
	 * @return
	 */
	private static List<DiseaseMREDTO> createDiseaseDTOList(Set<Disease> diseases2) {
		
		List<DiseaseMREDTO> diseasesMREDTO = new ArrayList<>();
		
		for (Disease disease : diseases2) {
			diseasesMREDTO.add(new DiseaseMREDTO(disease));
		}
		
		return diseasesMREDTO;
	}

	public boolean isWasOnExamination() {
		return wasOnExamination;
	}

	public void setWasOnExamination(boolean wasOnExamination) {
		this.wasOnExamination = wasOnExamination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public String getinterventionType() {
		return interventionType;
	}

	public void setinterventionType(String interventionType) {
		this.interventionType = interventionType;
	}

	public double getStaticPrice() {
		return staticPrice;
	}

	public void setStaticPrice(double staticPrice) {
		this.staticPrice = staticPrice;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSurname() {
		return doctorSurname;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<DiseaseMREDTO> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<DiseaseMREDTO> diseases) {
		this.diseases = diseases;
	}

	public List<PrescriptionMREDTO> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<PrescriptionMREDTO> prescriptions) {
		this.prescriptions = prescriptions;
	}

	@Override
	public String toString() {
		return "MedicalRecordExaminationDTO [id=" + id + ", date=" + date + ", specialisation=" + specialisation
				+ ", interventionType=" + interventionType + ", staticPrice=" + staticPrice + ", doctorName=" + doctorName
				+ ", doctorSurname=" + doctorSurname + ", roomNumber=" + roomNumber + ", diseases=" + diseases
				+ ", prescriptions=" + prescriptions + "]";
	}
	
}
