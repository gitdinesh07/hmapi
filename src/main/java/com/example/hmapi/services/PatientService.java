package com.example.hmapi.services;

import com.example.hmapi.models.Patient;
import com.example.hmapi.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    //using slf4j interface
    //private static  final Logger _logger = LoggerFactory.getLogger(PatientService.class);

    //using log4j interface
    private static  final Logger _logger = LogManager.getLogger(PatientService.class);
    @Autowired
    private PatientRepository repository;
    public PatientService()
    {
        _logger.info("patient service constructor invoked");
    }

    public List<Patient> GetPatients()
    {
        _logger.info("patient service GetPatients invoked");
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

    public Patient UpdatePatient(long id,Patient patient)
    {
        Patient updatedPatient = null;
        Optional<Patient> existingPatient = repository.findById(id);
        if(existingPatient.isPresent())
        {
            repository.save(patient);
            updatedPatient = patient;
        }
        return updatedPatient;
    }
    public Patient DeletePatient(long patientId)
    {
        var patient = GetPatient(patientId);
        if(patient != null)
            repository.deleteById(patientId);
        return patient;
    }
}
