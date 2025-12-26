package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimService;
import java.time.LocalDate;
import java.util.*;

@Service
public class WarrantyClaimServiceImpl {

    private final WarrantyClaimRecordRepository repo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;

    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository r,
            DeviceOwnershipRecordRepository d,
            StolenDeviceReportRepository s,
            FraudAlertRecordRepository a,
            FraudRuleRepository fr) {
        this.repo = r;
        this.deviceRepo = d;
        this.stolenRepo = s;
    }

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord c) {
        DeviceOwnershipRecord d = deviceRepo.findBySerialNumber(c.getSerialNumber())
                .orElseThrow(NoSuchElementException::new);

        boolean flagged =
                repo.existsBySerialNumberAndClaimReason(c.getSerialNumber(), c.getClaimReason())
                        || d.getWarrantyExpiration().isBefore(LocalDate.now())
                        || stolenRepo.existsBySerialNumber(c.getSerialNumber());

        c.setStatus(flagged ? "FLAGGED" : "PENDING");
        return repo.save(c);
    }

    public WarrantyClaimRecord updateClaimStatus(Long id, String s) {
        WarrantyClaimRecord c = repo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        c.setStatus(s);
        return repo.save(c);
    }

    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return repo.findById(id);
    }

    public List<WarrantyClaimRecord> getClaimsBySerial(String s) {
        return repo.findBySerialNumber(s);
    }

    public List<WarrantyClaimRecord> getAllClaims() {
        return repo.findAll();
    }
}
