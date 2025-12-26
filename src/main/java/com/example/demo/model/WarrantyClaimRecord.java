package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String claimantName;

    private String claimantEmail;

    @Column(nullable = false)
    private String claimReason;

    private LocalDateTime submittedAt;

    private String status = "PENDING";

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (status == null) status = "PENDING";
        if (submittedAt == null) submittedAt = LocalDateTime.now();
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}
