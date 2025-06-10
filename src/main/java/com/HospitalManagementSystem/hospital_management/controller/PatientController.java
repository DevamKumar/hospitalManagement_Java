package com.HospitalManagementSystem.hospital_management.controller;

import com.HospitalManagementSystem.hospital_management.entity.PatientEntity;
import com.HospitalManagementSystem.hospital_management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public String patients(Model model){
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("patient", new PatientEntity());
        return "patients";
    }

    @PostMapping
    public String addPatient(@ModelAttribute PatientEntity patient){
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

}
