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

    @Column(nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String severity; // LOW / MEDIUM / HIGH / CRITICAL

    private String message;

    @Column(nullable = false)
    private Boolean resolved = false;

    private LocalDateTime alertDate;

    @PrePersist
    public void onCreate() {
        if (resolved == null) {
            resolved = false;
        }
        this.alertDate = LocalDateTime.now();
    }
}
