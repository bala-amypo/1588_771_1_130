package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;

    private LocalDateTime submittedAt;

    private String status = "PENDING";
}
