package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord record) {
        return repository.save(record);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }
}
