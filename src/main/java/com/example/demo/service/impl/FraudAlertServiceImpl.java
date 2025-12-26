package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudAlertServiceImpl {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    public FraudAlertRecord createAlert(FraudAlertRecord r) {
        return repo.save(r);
    }

    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord r = repo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        r.setResolved(true);
        return repo.save(r);
    }

    public List<FraudAlertRecord> getAlertsByClaim(Long id) {
        return repo.findByClaimId(id);
    }

    public List<FraudAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
