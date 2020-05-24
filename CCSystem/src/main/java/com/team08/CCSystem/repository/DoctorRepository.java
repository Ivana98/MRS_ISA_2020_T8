/**
 * 
 */
package com.team08.CCSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team08.CCSystem.model.Doctor;

/**
 * @author Veljko
 *
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	Doctor findByEmail(String email);

	@Query("select d from Doctor d where d.clinic.id is ?1")
	List<Doctor> findAllByClinic(Long clinicId);

}
