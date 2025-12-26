package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repository;

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        return repository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serial) {
        return repository.findBySerialNumber(serial);
    }
}
