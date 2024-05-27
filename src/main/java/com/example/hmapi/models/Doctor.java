package com.example.hmapi.models;


import com.example.hmapi.models.enums.doctorSpecility;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String city;

    private doctorSpecility specility;
}
