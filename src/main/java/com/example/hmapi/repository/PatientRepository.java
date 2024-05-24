package com.example.hmapi.repository;

import com.example.hmapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PatientRepository<Patient> extends JpaRepository<com.example.hmapi.models.Patient, Long> {
}
