package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StolenDeviceReport {

    @Id
    @GeneratedValue
    private Long id;

    private String serialNumber;
}
