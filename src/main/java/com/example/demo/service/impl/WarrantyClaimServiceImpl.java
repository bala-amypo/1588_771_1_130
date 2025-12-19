package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repo;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        return repo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = repo.findById(claimId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Warranty claim not found with id: " + claimId));

        claim.setStatus(status);
        return repo.save(claim);
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Warranty claim not found with id: " + id));
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repo.findAll();
    }
}
