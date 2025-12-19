package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository repo;

    public FraudAlertServiceImpl(FraudAlertRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        alert.setResolved(false);
        return repo.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setResolved(true);
        return repo.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
