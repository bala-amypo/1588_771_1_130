package com.example.demo.model;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {
    private Long id;
    private String serialNumber;
    private String claimReason;

    @Builder.Default
    private String status = "PENDING";
}
