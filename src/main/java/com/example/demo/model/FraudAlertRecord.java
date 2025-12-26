package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudAlertRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity; // LOW/MEDIUM/HIGH/CRITICAL
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved = false;

    @PrePersist
    public void prePersist() {
        if (resolved == null) resolved = false;
        if (alertDate == null) alertDate = LocalDateTime.now();
    }
}
