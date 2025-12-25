package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository deviceRepo,
            StolenDeviceReportRepository stolenRepo,
            FraudAlertRecordRepository alertRepo,
            FraudRuleRepository ruleRepo) {

        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }

    /**
     * Submit a warranty claim.
     *
     * FLAGGED if:
     *  - Duplicate claim (same serial + reason)
     *  - Device is reported stolen
     *  - Warranty is expired
     */
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device = deviceRepo
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(NoSuchElementException::new);

        boolean duplicateClaim =
                claimRepo.existsBySerialNumberAndClaimReason(
                        claim.getSerialNumber(),
                        claim.getClaimReason()
                );

        boolean stolenDevice =
                stolenRepo.existsBySerialNumber(claim.getSerialNumber());

        boolean warrantyExpired =
                device.getWarrantyExpiration() != null &&
                device.getWarrantyExpiration().isBefore(LocalDate.now());

        if (duplicateClaim || stolenDevice || warrantyExpired) {
            claim.setStatus("FLAGGED");
        }

        return claimRepo.save(claim);
    }

    /**
     * Update claim status (APPROVED / REJECTED / etc.)
     */
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {

        WarrantyClaimRecord claim = claimRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);

        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    /**
     * Get claim by ID
     */
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    /**
     * Get all claims
     */
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }

    /**
     * Get claims by device serial number
     */
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findBySerialNumber(serialNumber);
    }
}
