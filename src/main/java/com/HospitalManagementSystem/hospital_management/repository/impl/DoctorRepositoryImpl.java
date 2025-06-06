package com.HospitalManagementSystem.hospital_management.repository.impl;

import com.HospitalManagementSystem.hospital_management.entity.DoctorEntity;
import com.HospitalManagementSystem.hospital_management.repository.DoctorRepository;

import java.util.List;

public abstract class DoctorRepositoryImpl implements DoctorRepository {
    private final DoctorRepository doctorRepository =

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
