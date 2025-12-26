package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;

    private String serialNumber;

    private String alertType;

    private String severity;

    private String message;

    @Builder.Default
    private Boolean resolved = false;

    private LocalDateTime alertDate;

    @PrePersist
    void onCreate() {
        this.alertDate = LocalDateTime.now();
        if (resolved == null) {
            resolved = false;
        }
    }
}
