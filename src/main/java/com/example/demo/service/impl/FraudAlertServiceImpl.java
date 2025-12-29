package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repo.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repo.findById(id)
                .orElseThrow(() ->
                        new java.util.NoSuchElementException("Fraud alert not found"));
        alert.setResolved(true);
        return repo.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }

    // ✅ MISSING METHOD (FIX)
    @Override
    public Optional<FraudAlertRecord> getAlertById(Long id) {
        return repo.findById(id);
    }

    // ✅ REQUIRED BY INTERFACE
    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
