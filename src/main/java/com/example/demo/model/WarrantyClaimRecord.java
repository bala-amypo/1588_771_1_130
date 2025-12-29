package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(nullable = false)
    @Builder.Default
    private String status = "PENDING"; // PENDING / APPROVED / REJECTED / FLAGGED

    private LocalDateTime submittedAt;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        if (status == null) {
            status = "PENDING";
        }
        this.submittedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
