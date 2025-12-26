package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repository;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord saveAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public List<FraudAlertRecord> getResolvedAlerts(boolean resolved) {
        return repository.findByResolved(resolved);
    }

    @Override
    public FraudAlertRecord updateAlertStatus(Long id, boolean resolved) {
        FraudAlertRecord alert = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setResolved(resolved);
        return repository.save(alert);
    }
}
