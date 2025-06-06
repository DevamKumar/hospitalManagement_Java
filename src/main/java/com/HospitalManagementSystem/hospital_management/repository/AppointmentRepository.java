package com.HospitalManagementSystem.hospital_management.repository;

import com.HospitalManagementSystem.hospital_management.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
