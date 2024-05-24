package com.example.hmapi.services;

import com.example.hmapi.models.Patient;
import com.example.hmapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;
    public List<Patient> GetPatients()
    {
        var result =  repository.findAll();
        return result;
    }

    public Patient GetPatient(long patientId)
    {
        Optional<Patient> patient = repository.findById(patientId);
        return patient.orElse(null);
    }

    public Patient CreatePatient(Patient patient)
    {
        repository.save(patient);
        return patient;
    }

    public Patient DeletePatient(long patientId)
    {
        var patient = GetPatient(patientId);
        if(patient != null)
            repository.deleteById(patientId);
        return patient;
    }
}
