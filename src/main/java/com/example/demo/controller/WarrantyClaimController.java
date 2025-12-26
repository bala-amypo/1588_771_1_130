package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.impl.WarrantyClaimServiceImpl;

import java.util.List;
import java.util.Optional;

public class WarrantyClaimController {

    private final WarrantyClaimServiceImpl service;

    public WarrantyClaimController(WarrantyClaimServiceImpl service) {
        this.service = service;
    }

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord record) {
        return service.submitClaim(record);
    }

    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        return service.updateClaimStatus(id, status);
    }

    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return service.getClaimById(id);
    }

    public List<WarrantyClaimRecord> getClaimsBySerial(String serial) {
        return service.getClaimsBySerial(serial);
    }

    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }
}
