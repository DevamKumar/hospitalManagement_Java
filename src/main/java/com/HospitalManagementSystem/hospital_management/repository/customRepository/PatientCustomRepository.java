package com.HospitalManagementSystem.hospital_management.repository.customRepository;

import com.HospitalManagementSystem.hospital_management.entity.PatientEntity;
import java.util.List;

public interface PatientCustomRepository {
    List<PatientEntity> getAllCustomPatients();
    PatientEntity saveCustomPatient(PatientEntity patient);
}
