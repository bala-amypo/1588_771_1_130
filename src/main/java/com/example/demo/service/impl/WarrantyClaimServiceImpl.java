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
    public WarrantyClaimRecord create(WarrantyClaimRecord record) {
        return repo.save(record);
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @Override
    public List<WarrantyClaimRecord> getBySerial(String serial) {
        return repo.findBySerial(serial);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repo.findAll();
    }
}
