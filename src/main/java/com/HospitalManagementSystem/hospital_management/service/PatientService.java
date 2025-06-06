package com.HospitalManagementSystem.hospital_management.service;

import com.HospitalManagementSystem.hospital_management.entity.PatientEntity;
import com.HospitalManagementSystem.hospital_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientEntity> getAllPatients(){
        return patientRepository.findAll();
    }

    public PatientEntity savePatient(PatientEntity patient){
        return patientRepository.save(patient);
    }
}
