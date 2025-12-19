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
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        return repo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repo.findAll();
    }
}
