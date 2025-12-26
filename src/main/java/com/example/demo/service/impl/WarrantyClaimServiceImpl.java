package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimService;
import java.time.LocalDate;
import java.util.*;

public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository c,
            DeviceOwnershipRecordRepository d,
            StolenDeviceReportRepository s,
            FraudAlertRecordRepository a,
            FraudRuleRepository r) {
        this.claimRepo = c;
        this.deviceRepo = d;
        this.stolenRepo = s;
        this.alertRepo = a;
        this.ruleRepo = r;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        DeviceOwnershipRecord device =
                deviceRepo.findBySerialNumber(claim.getSerialNumber())
                        .orElseThrow();

        boolean flagged =
                claimRepo.existsBySerialNumberAndClaimReason(
                        claim.getSerialNumber(), claim.getClaimReason())
                || device.getWarrantyExpiration().isBefore(LocalDate.now())
                || stolenRepo.existsBySerialNumber(claim.getSerialNumber());

        claim.setStatus(flagged ? "FLAGGED" : "PENDING");
        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord c = claimRepo.findById(id).orElseThrow();
        c.setStatus(status);
        return claimRepo.save(c);
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
