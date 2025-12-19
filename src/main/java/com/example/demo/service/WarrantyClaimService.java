package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord create(WarrantyClaimRecord record);

    WarrantyClaimRecord getById(Long id);

    List<WarrantyClaimRecord> getBySerial(String serial);

    WarrantyClaimRecord updateStatus(Long id, String status);

    List<WarrantyClaimRecord> getAll();
}
