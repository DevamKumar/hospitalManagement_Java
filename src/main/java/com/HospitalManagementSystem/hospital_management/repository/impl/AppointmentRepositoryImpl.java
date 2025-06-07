package com.HospitalManagementSystem.hospital_management.repository.impl;

import com.HospitalManagementSystem.hospital_management.entity.AppointmentEntity;
import com.HospitalManagementSystem.hospital_management.repository.customRepository.AppointmentCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AppointmentRepositoryImpl implements AppointmentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AppointmentEntity> getAllCustomAppointments() {
        return entityManager.createQuery("SELECT a FROM AppointmentEntity a", AppointmentEntity.class).getResultList();
    }

    @Override
    public AppointmentEntity saveCustomAppointment(AppointmentEntity appointment) {
        if (appointment.getId() == null) {
            entityManager.persist(appointment);
            return appointment;
        } else {
            return entityManager.merge(appointment);
        }
    }
}
