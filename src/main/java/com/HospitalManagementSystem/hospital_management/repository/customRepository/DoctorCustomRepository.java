package com.HospitalManagementSystem.hospital_management.repository.customRepository;

import com.HospitalManagementSystem.hospital_management.entity.DoctorEntity;

import java.util.List;

public interface DoctorCustomRepository {
    List<DoctorEntity> getAllCustomDoctors();
    DoctorEntity saveCustomDoctor(DoctorEntity doctor);
}
