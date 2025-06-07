package com.HospitalManagementSystem.hospital_management.service;

import com.HospitalManagementSystem.hospital_management.entity.AppointmentEntity;
import com.HospitalManagementSystem.hospital_management.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.getAllCustomAppointments();
    }

    public AppointmentEntity saveAppointment(AppointmentEntity appointment) {
        return appointmentRepository.saveCustomAppointment(appointment);
    }
}
