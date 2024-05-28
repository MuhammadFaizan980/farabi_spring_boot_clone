package com.clinics.farabi.patients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientRepository extends JpaRepository<PatientEntity, Integer> {
    Page<PatientEntity> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Page<PatientEntity> findAllByLastNameContaining(String lastName, Pageable pageable);

    Page<PatientEntity> findAllByEmailContaining(String email, Pageable pageable);

    Page<PatientEntity> findAllByPhoneNumberContaining(String phone, Pageable pageable);
}
