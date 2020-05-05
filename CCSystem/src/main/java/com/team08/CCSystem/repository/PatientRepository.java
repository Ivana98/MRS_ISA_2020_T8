 /**
 * 
 */
package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.Patient;

/**
 * @author Veljko
 *
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
