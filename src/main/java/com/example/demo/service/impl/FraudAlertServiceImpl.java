package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    /**
     * Create a fraud alert
     */
    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repo.save(alert);
    }

    /**
     * Resolve a fraud alert by ID
     */
    @Override
    public FraudAlertRecord resolveAlert(Long id) {

        FraudAlertRecord alert = repo.findById(id)
                .orElseThrow(NoSuchElementException::new);

        alert.setResolved(true);
        return repo.save(alert);
    }

    /**
     * Get fraud alerts by claim ID
     */
    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }
}
