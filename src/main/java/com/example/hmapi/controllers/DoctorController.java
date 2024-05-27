package com.example.hmapi.controllers;

import com.example.hmapi.models.APIResponse;
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
    public ResponseEntity<APIResponse> GetDoctors()
    {
        List<Doctor> doctors = service.GetDoctors();
        return ResponseEntity.ok(APIResponse.Success(doctors));
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> GetDoctor(@PathVariable UUID id)
    {
        Optional<Doctor> getDoctor = Optional.ofNullable(service.GetDoctor(id));
        if(getDoctor.isPresent())
            return ResponseEntity.ok(APIResponse.Success(getDoctor.get(),null));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(APIResponse.Fail("doctor not found"));
    }

    @PostMapping
    public APIResponse CreateDoctor(@RequestBody Doctor doctor)
    {
        Doctor created = service.CreateDoctor(doctor);
        return APIResponse.Success(created,"record created");
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<APIResponse> UpdateDoctor(@PathVariable UUID doctorId, @RequestBody Doctor doctor)
    {
        Doctor updatedDoctor = service.UpdateDoctor(doctor);
        if(updatedDoctor == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(APIResponse.Fail("doctor not found"));
        else
            return ResponseEntity.ok(APIResponse.Success(updatedDoctor,"record updated"));
    }
}
