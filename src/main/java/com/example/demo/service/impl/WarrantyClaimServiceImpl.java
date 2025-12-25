package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repo;

    @Override
    public WarrantyClaimRecord submitWarrantyClaim(WarrantyClaimRecord claim) {
        return repo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAllWarrantyClaims() {
        return repo.findAll();
    }

    @Override
    public WarrantyClaimRecord getWarrantyClaimById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteWarrantyClaim(Long id) {
        repo.deleteById(id);
    }
}
