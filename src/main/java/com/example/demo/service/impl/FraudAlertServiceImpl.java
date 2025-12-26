package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import java.util.*;

public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord a) {
        return repo.save(a);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord f = repo.findById(id).orElseThrow();
        f.setResolved(true);
        return repo.save(f);
    }

    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }
}
