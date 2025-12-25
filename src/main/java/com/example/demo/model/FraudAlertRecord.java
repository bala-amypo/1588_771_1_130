package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fraud_alert")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertCode;

    private String description;

    private boolean resolved;
}
