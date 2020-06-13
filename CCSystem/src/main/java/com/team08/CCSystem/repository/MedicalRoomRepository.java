/**
 * 
 */
package com.team08.CCSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.enums.InterventionType;

/**
 * @author Veljko
 *
 */
public interface MedicalRoomRepository extends JpaRepository<MedicalRoom, Long> {
	
	@Query("select m from MedicalRoom m where m.clinic.id is ?1")
	List<MedicalRoom> findAllByClinic(Long clinicId);

	@Query("select m from MedicalRoom m where (m.intervensionType is ?2) and "
			+ "m.clinic.id is ?1")
	List<MedicalRoom> findAllByClinicAndExamination(Long clinicId, InterventionType it);

	/**
	 * @param clinicId
	 * @param interventionType
	 * @return
	 */
	@Query("select m from MedicalRoom m where (m.clinic.id is ?1) "
			+ "and (m.intervensionType is ?2)")
	List<MedicalRoom> findAllByClinicAndInterventionType(Long clinicId, InterventionType interventionType);
}
