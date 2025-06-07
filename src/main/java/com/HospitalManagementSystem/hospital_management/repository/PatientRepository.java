package com.HospitalManagementSystem.hospital_management.repository;

import com.HospitalManagementSystem.hospital_management.entity.PatientEntity;
import com.HospitalManagementSystem.hospital_management.repository.customRepository.PatientCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long>, PatientCustomRepository {
}
