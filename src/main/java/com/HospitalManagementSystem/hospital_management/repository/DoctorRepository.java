package com.HospitalManagementSystem.hospital_management.repository;

import com.HospitalManagementSystem.hospital_management.entity.DoctorEntity;
import com.HospitalManagementSystem.hospital_management.repository.customRepository.DoctorCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>, DoctorCustomRepository {
}
