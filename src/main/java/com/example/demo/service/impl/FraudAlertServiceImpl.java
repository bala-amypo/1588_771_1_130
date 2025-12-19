package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repository;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        Optional<FraudAlertRecord> alertOpt = repository.findById(id);
        if (alertOpt.isPresent()) {
            FraudAlertRecord alert = alertOpt.get();
            alert.setResolved(true);  // Assuming there’s a 'resolved' field in the entity
            return repository.save(alert);
        }
        return null; // or throw exception if alert not found
    }

    @Override
    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repository.findByClaimId(claimId);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
