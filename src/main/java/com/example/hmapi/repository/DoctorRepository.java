package com.example.hmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository<Doctor> extends JpaRepository<com.example.hmapi.models.Doctor, UUID> {
}
