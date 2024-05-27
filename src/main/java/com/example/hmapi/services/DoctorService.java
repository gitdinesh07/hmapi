package com.example.hmapi.services;

import com.example.hmapi.models.Doctor;
import com.example.hmapi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor GetDoctor(UUID id)
    {
        Optional<Doctor> getDoctor = repository.findById(id);
        return getDoctor.orElse(null);
    }

    public List<Doctor> GetDoctors() {
        return repository.findAll();
    }

    public Doctor CreateDoctor(Doctor doctor) {
        repository.save(doctor);
        return doctor;
    }

    public Doctor UpdateDoctor(Doctor doctor) {
        Optional<Doctor> existDoctor = repository.findById(doctor.getId());
        if(existDoctor.isPresent())
        {
            repository.save(doctor);
            return doctor;
        }
        return null;
    }
}
