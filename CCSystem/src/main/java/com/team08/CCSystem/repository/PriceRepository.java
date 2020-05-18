/**
 * 
 */
package com.team08.CCSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.Price;

/**
 * @author Veljko
 *
 */
public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query("select p from Price p where (p.clinic.id is ?1)")
	List<Price> findAllFromClinic(Long clinicId);
}
