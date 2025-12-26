package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepo,
                                    DeviceOwnershipRecordRepository deviceRepo,
                                    StolenDeviceReportRepository stolenRepo) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));

        // Check duplicate claim
        if (claimRepo.existsBySerialNumberAndClaimReason(claim.getSerialNumber(), claim.getClaimReason())) {
            claim.setStatus("FLAGGED");
        }

        // Check warranty expiration
        if (device.getWarrantyExpiration() != null && device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            claim.setStatus("FLAGGED");
        }

        // Check stolen
        if (stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            claim.setStatus("FLAGGED");
        }

        claim.setSubmittedAt(LocalDateTime.now());
        if (claim.getStatus() == null) claim.setStatus("PENDING");
        claim.setCreatedAt(LocalDateTime.now());

        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));
        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
}
