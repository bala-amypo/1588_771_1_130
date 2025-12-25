package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "device_ownership")
@Data                   // generates getters, setters, toString, equals, hashcode
@NoArgsConstructor       // no-args constructor
@AllArgsConstructor      // all-args constructor
@Builder                 // builder pattern
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private Boolean status;

    private LocalDate warrantyExpiration; // ← needed for test cases
}
