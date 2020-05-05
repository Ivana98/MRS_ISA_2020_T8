/**
 * 
 */
package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.Prescription;

/**
 * @author Veljko
 *
 */
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
