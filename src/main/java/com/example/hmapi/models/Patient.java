package com.example.hmapi.models;

import com.example.hmapi.models.enums.genderEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private Long id;
    private String name;
    private genderEnum gender;
    private int age;
}
