package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.Patient;
import com.team08.CCSystem.model.VerificationToken;

public interface VerificationTokenRepository 
extends JpaRepository<VerificationToken, Long> {

  VerificationToken findByToken(String token);

  //find by user - patient
  VerificationToken findByPatient(Patient patient);
}
