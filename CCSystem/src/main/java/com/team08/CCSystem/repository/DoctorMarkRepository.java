/**
 * 
 */
package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.DoctorMark;

public interface DoctorMarkRepository extends JpaRepository<DoctorMark, Long> {

	@Query(value = "SELECT m FROM DoctorMark m "
			 + "WHERE (m.doctor.id is ?1) "
			 + "and (m.patient.id is ?2) ")
		DoctorMark findDoctorMarkByIds(Long doctorId, Long patientId);
	
}
