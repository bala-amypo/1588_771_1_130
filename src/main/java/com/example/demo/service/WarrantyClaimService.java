package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;

public interface WarrantyClaimService {
    WarrantyClaimRecord submitClaim(WarrantyClaimRecord record);
    List<WarrantyClaimRecord> getAllClaims();
}
