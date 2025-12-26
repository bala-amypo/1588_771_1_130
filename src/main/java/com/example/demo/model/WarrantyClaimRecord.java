package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String claimReason;

    @Builder.Default
    private String status = "PENDING";
}
