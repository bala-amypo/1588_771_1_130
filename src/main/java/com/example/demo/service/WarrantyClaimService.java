package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.*;

public interface WarrantyClaimService {
    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);
    WarrantyClaimRecord updateClaimStatus(Long id, String status);
    Optional<WarrantyClaimRecord> getClaimById(Long id);
    List<WarrantyClaimRecord> getAllClaims();
    List<WarrantyClaimRecord> getClaimsBySerial(String serial);
}
