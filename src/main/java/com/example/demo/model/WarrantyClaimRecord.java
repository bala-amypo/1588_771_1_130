package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "warranty_claim_records")
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

    private String status = "PENDING";

    private LocalDateTime submittedAt;


    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    @OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
    private List<FraudAlertRecord> alerts;

    public WarrantyClaimRecord() {}

    public WarrantyClaimRecord(String serialNumber, String claimantName, String claimReason) {
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimReason = claimReason;
    }

    @PrePersist
    public void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
