package com.team08.CCSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.dto.AbsenceUserDTO;
import com.team08.CCSystem.model.Absence;

/**
 * @author Veljko
 *
 */
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

	/**
	 * @param clinicId is id of clinic
	 * @return List of absences
	 */
	@Query("select a from Absence a where (a.user.clinic.id is ?1) "
			+ "and (a.confirmed is null)")
	List<AbsenceUserDTO> getAllFromClinic(Long clinicId);

}
