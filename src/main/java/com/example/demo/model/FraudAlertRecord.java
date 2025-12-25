package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudAlertRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long claimId;
    private String serialNumber;

    private Boolean resolved = false;
}
