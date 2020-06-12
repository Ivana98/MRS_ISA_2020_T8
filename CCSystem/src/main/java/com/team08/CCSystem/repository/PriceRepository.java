/**
 * 
 */
package com.team08.CCSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;

/**
 * @author Veljko
 *
 */
public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query("select p from Price p where (p.clinic.id is ?1)")
	List<Price> findAllFromClinic(Long clinicId);

	/**
	 * @param clinicId
	 * @param it is intervention type string
	 * @param spec is specialisation string
	 * @return
	 */
	@Query("select p from Price p "
			+ "where (p.clinic.id is ?1) "
			+ "and (p.examinationType.specialisation is ?3) "
			+ "and (p.examinationType.interventionType is ?2)")
	Price findByClinicIdInterventionTypeAndSpecialisation(Long clinicId, InterventionType it, Specialisation spec);
}
