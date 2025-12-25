package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository repository;

    public FraudAlertServiceImpl(FraudAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord saveAlert(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getResolvedAlerts(boolean resolved) {
        return repository.findAll().stream().filter(a -> a.isResolved() == resolved).toList();
    }

    @Override
    public void updateAlertStatus(Long id, boolean resolved) {
        FraudAlertRecord alert = repository.findById(id).orElseThrow();
        alert.setResolved(resolved);
        repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
