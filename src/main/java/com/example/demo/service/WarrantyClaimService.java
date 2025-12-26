package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {
    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);
    List<WarrantyClaimRecord> getClaimsBySerial(String serial);
}
