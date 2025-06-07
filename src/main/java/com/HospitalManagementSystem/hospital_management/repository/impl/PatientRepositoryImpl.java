package com.HospitalManagementSystem.hospital_management.repository.impl;

import com.HospitalManagementSystem.hospital_management.entity.PatientEntity;
import com.HospitalManagementSystem.hospital_management.repository.customRepository.PatientCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PatientRepositoryImpl implements PatientCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientEntity> getAllCustomPatients() {
        return entityManager.createQuery("SELECT p FROM PatientEntity p", PatientEntity.class).getResultList();
    }

    @Override
    public PatientEntity saveCustomPatient(PatientEntity patient) {
        if (patient.getId() == null) {
            entityManager.persist(patient);
            return patient;
        } else {
            return entityManager.merge(patient);
        }
    }
}
