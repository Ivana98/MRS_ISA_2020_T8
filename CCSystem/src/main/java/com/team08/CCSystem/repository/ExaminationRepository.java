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
}
