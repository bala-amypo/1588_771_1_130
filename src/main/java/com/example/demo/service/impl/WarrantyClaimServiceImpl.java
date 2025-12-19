package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord submit(WarrantyClaimRecord claim) {
        return repository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WarrantyClaimRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<WarrantyClaimRecord> getBySerialNumber(String serial) {
        return repository.findBySerialNumber(serial);
    }

    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {
        WarrantyClaimRecord claim = repository.findById(id).orElseThrow();
        claim.setStatus(status);
        return repository.save(claim);
    }
}
