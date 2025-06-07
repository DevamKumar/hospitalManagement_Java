package com.HospitalManagementSystem.hospital_management.repository.customRepository;

import com.HospitalManagementSystem.hospital_management.entity.AppointmentEntity;
import java.util.List;

public interface AppointmentCustomRepository {
    List<AppointmentEntity> getAllCustomAppointments();
    AppointmentEntity saveCustomAppointment(AppointmentEntity appointment);
}
