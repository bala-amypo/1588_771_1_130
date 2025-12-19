package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;
import java.util.Optional;

public interface WarrantyClaimService {
    WarrantyClaimRecord submit(WarrantyClaimRecord claim);
    List<WarrantyClaimRecord> getAll();
    Optional<WarrantyClaimRecord> getById(Long id);
    Optional<WarrantyClaimRecord> getBySerialNumber(String serial);
    WarrantyClaimRecord updateStatus(Long id, String status);
}
