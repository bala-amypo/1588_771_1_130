package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private String severity;

    private String message;

    private LocalDateTime alertDate;

    private Boolean resolved = false;

    @PrePersist
    public void prePersist() {
        if (resolved == null) resolved = false;
        if (alertDate == null) alertDate = LocalDateTime.now();
    }
}
