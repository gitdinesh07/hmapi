package com.example.hmapi.controllers;

import com.example.hmapi.models.Patient;
import com.example.hmapi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService _service;

    @GetMapping
    public List<Patient> GetPatients()
    {
        var result = _service.GetPatients();
        return result;
    }

    @GetMapping("/{patientId}")
    public Patient GetPatient(@PathVariable long patientId)
    {
        return _service.GetPatient(patientId);
    }

    @PostMapping
    public Patient CreatePatient(@RequestBody Patient patient)
    {
        _service.CreatePatient(patient);
        return patient;
    }

    @DeleteMapping("/{patientId}")
    public Patient DeletePatient(@PathVariable long patientId)
    {
        return _service.DeletePatient(patientId);
    }

}
