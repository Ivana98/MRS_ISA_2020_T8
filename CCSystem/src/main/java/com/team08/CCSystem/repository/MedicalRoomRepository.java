/**
 * 
 */
package com.team08.CCSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.MedicalRoom;

/**
 * @author Veljko
 *
 */
public interface MedicalRoomRepository extends JpaRepository<MedicalRoom, Long> {
	
	@Query("select m from MedicalRoom m where m.clinic.id is ?1")
	List<MedicalRoom> findAllByClinic(Long clinicId);

}
