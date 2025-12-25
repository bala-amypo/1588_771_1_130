package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord submitWarrantyClaim(WarrantyClaimRecord claim);

    List<WarrantyClaimRecord> getAllWarrantyClaims();

    WarrantyClaimRecord getWarrantyClaimById(Long id);

    void deleteWarrantyClaim(Long id);
}
