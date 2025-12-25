package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

public interface WarrantyClaimService {
    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);
    WarrantyClaimRecord updateClaimStatus(Long id, String status);
}
