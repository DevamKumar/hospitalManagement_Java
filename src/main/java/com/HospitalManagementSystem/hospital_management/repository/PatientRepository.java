package com.HospitalManagementSystem.hospital_management.repository;

import com.HospitalManagementSystem.hospital_management.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
}
