package com.HospitalManagementSystem.hospital_management.repository.impl;

import com.HospitalManagementSystem.hospital_management.entity.DoctorEntity;
import com.HospitalManagementSystem.hospital_management.repository.customRepository.DoctorCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DoctorEntity> getAllCustomDoctors() {
        return entityManager.createQuery("SELECT d FROM DoctorEntity d", DoctorEntity.class).getResultList();
    }

    @Override
    public DoctorEntity saveCustomDoctor(DoctorEntity doctor) {
        if (doctor.getId() == null) {
            entityManager.persist(doctor);
            return doctor;
        } else {
            return entityManager.merge(doctor);
        }
    }
}
