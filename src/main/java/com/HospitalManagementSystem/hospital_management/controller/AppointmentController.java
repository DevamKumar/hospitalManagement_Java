package com.HospitalManagementSystem.hospital_management.controller;

import com.HospitalManagementSystem.hospital_management.entity.AppointmentEntity;
import com.HospitalManagementSystem.hospital_management.repository.AppointmentRepository;
import com.HospitalManagementSystem.hospital_management.repository.DoctorRepository;
import com.HospitalManagementSystem.hospital_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @GetMapping
    public String appointments(Model model){
        model.addAttribute("appointmentsList", appointmentRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("appointments", new AppointmentEntity());
        return "appointments";
    }
    @PostMapping
    public String addAppointment(@ModelAttribute AppointmentEntity appointment){
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }
}
