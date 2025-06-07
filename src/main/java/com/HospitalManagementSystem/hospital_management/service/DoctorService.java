package com.HospitalManagementSystem.hospital_management.service;

import com.HospitalManagementSystem.hospital_management.entity.DoctorEntity;
import com.HospitalManagementSystem.hospital_management.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.getAllCustomDoctors();
    }

    public DoctorEntity saveDoctor(DoctorEntity doctor) {
        return doctorRepository.saveCustomDoctor(doctor);
    }
}
