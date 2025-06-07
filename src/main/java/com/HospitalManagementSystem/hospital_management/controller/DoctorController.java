package com.HospitalManagementSystem.hospital_management.controller;

import com.HospitalManagementSystem.hospital_management.entity.DoctorEntity;
import com.HospitalManagementSystem.hospital_management.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public String doctors(Model model){
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }

    @PostMapping
    public String addDoctor(@ModelAttribute DoctorEntity doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
}
