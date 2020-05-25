package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.ClinicAdmin;

public interface ClinicAdminRepository extends JpaRepository<ClinicAdmin, Long>{
	ClinicAdmin findByEmail(String email);
}
