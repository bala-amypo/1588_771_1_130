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
    public FraudAlertRecord create(FraudAlertRecord alert) {
        alert.setResolved(false);
        return repository.save(alert);
    }

    @Override
    public FraudAlertRecord resolve(Long id) {
        FraudAlertRecord alert = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setResolved(true);
        return repository.save(alert);
    }

    @Override
    public Optional<FraudAlertRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<FraudAlertRecord> getBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getAll() {
        return repository.findAll();
    }
}
