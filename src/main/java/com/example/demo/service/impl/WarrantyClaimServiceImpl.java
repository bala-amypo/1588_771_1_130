package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.WarrantyClaimService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class WarrantyClaimServiceImpl implements WarrantyClaimService {

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
            FraudRuleRepository ruleRepo
    ) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        if (claimRepo.existsBySerialNumberAndClaimReason(claim.getSerialNumber(), claim.getClaimReason())
                || device.getWarrantyExpiration().isBefore(java.time.LocalDate.now())
                || stolenRepo.existsBySerialNumber(device.getSerialNumber())) {
            claim.setStatus("FLAGGED");
        }
        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord claim = claimRepo.findById(id).orElseThrow();
        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serial) {
        return claimRepo.findBySerialNumber(serial);
    }
}
