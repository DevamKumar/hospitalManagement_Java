package com.HospitalManagementSystem.hospital_management.repository;

import com.HospitalManagementSystem.hospital_management.entity.AppointmentEntity;
import com.HospitalManagementSystem.hospital_management.repository.customRepository.AppointmentCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>, AppointmentCustomRepository {
}
