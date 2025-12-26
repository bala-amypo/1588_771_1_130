package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        alert.setAlertDate(LocalDateTime.now());
        if (alert.getResolved() == null) alert.setResolved(false);
        return repo.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Alert not found"));
        alert.setResolved(true);
        return repo.save(alert);
    }

    @Override
    public Optional<FraudAlertRecord> getAlertById(Long id) {
        return repo.findById(id);
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
