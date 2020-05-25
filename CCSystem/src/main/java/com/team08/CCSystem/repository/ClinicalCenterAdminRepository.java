package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.ClinicalCenterAdmin;

public interface ClinicalCenterAdminRepository extends JpaRepository<ClinicalCenterAdmin, Long> {
	ClinicalCenterAdmin findByEmail(String email);
}
