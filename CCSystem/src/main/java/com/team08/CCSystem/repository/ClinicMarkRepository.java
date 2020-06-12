/**
 * 
 */
package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.ClinicMark;

/**
 * @author Veljko
 *
 */
public interface ClinicMarkRepository extends JpaRepository<ClinicMark, Long> {
	
	@Query(value = "SELECT m FROM ClinicMark m "
		 + "WHERE (m.clinic.id is ?1) "
		 + "and (m.patient.id is ?2) ")
	ClinicMark findClinicMarkByIds(Long clinicId, Long patientId);
					 

}
