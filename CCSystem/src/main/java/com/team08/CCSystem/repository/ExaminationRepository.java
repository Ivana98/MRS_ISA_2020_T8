/**
 * 
 */
package com.team08.CCSystem.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.Examination;

/**
 * @author Veljko
 *
 */
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

	@Query("SELECT e FROM Examination e "
			+ "WHERE (e.date BETWEEN ?1 AND ?2) "
			+ "and (e.doctor.id is ?3) ")//and (e.medicalRoom.id is ?4)
	List<Examination> findExaminationsBetweenDatesAndDoctorId(Date startDate, Date endDate, Long doctorId);
	
	@Query("SELECT e FROM Examination e WHERE (e.date BETWEEN ?1 AND ?2) and (e.medicalRoom.id is ?3)")
	List<Examination> findExaminationsBetweenDates(Date startDate, Date endDate, Long roomId);
	
	@Query("select e from Examination e "
			+ "where (e.medicalRoom.id is ?1) and "
			+ "(e.date > ?2)")
	List<Examination> findExaminationWithRoomIdAndAfterDate(Long roomId, Date date);
	
	@Query("select e from Examination e where (e.price.id is ?1) and "
			+ "(e.date > ?2) and "
			+ "(e.patient.id is null)")
	List<Examination> findAllFreeFromClinic(Long clinicId, Date date);

	/**
	 * @param startDate
	 * @param endDate
	 * @param clinicId
	 * @return
	 */
	@Query("SELECT e FROM Examination e "
			+ "WHERE (e.date BETWEEN ?1 AND ?2) "
			+ "and (e.doctor.clinic.id is ?3) ")
	List<Examination> findExaminationsBetweenDatesAndClinicId(Date startDate, Date endDate, Long clinicId);
}
