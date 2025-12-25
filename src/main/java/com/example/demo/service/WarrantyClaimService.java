package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;
import java.util.Optional;

public interface WarrantyClaimService {

    /**
     * Submit a new warranty claim
     */
    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);

    /**
     * Update claim status (APPROVED / REJECTED / FLAGGED)
     */
    WarrantyClaimRecord updateClaimStatus(Long id, String status);

    /**
     * Get claim by ID
     */
    Optional<WarrantyClaimRecord> getClaimById(Long id);

    /**
     * Get all warranty claims
     */
    List<WarrantyClaimRecord> getAllClaims();

    /**
     * Get claims by device serial number
     */
    List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);
}
