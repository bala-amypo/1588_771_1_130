package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repo;

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        claim.setClaimStatus("PENDING");
        return repo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord claim = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        claim.setClaimStatus(status);
        return repo.save(claim);
    }
}
