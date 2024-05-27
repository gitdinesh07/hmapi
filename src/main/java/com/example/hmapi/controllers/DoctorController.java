package com.example.hmapi.controllers;

import com.example.hmapi.models.Doctor;
import com.example.hmapi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public ResponseEntity<List<Doctor>> GetDoctors()
    {
        List<Doctor> doctors = service.GetDoctors();
        return ResponseEntity.ok(doctors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> GetDoctor(@PathVariable UUID id)
    {
        Optional<Doctor> getDoctor = Optional.ofNullable(service.GetDoctor(id));
        if(getDoctor.isPresent())
            return ResponseEntity.ok(getDoctor.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public Doctor CreateDoctor(@RequestBody Doctor doctor)
    {
        Doctor created = service.CreateDoctor(doctor);
        return created;
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<Doctor> UpdateDoctor(@PathVariable UUID doctorId, @RequestBody Doctor doctor)
    {
        Doctor updatedDoctor = service.UpdateDoctor(doctor);
        if(updatedDoctor == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(updatedDoctor);
    }
}
