package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}