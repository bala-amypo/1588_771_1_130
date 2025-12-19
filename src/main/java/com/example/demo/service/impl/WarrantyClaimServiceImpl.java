package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repo;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public WarrantyClaimRecord create(WarrantyClaimRecord record) {
        record.setCreatedAt(LocalDateTime.now());
        record.setStatus("SUBMITTED");
        return repo.save(record);
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @Override
    public List<WarrantyClaimRecord> getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {
        WarrantyClaimRecord claim = getById(id);
        claim.setStatus(status);
        return repo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repo.findAll();
    }
}
