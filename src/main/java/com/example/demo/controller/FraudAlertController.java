package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.impl.FraudAlertServiceImpl;

import java.util.List;

public class FraudAlertController {

    private final FraudAlertServiceImpl service;

    public FraudAlertController(FraudAlertServiceImpl service) {
        this.service = service;
    }

    public FraudAlertRecord createAlert(FraudAlertRecord record) {
        return service.createAlert(record);
    }

    public FraudAlertRecord resolveAlert(Long id) {
        return service.resolveAlert(id);
    }

    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return service.getAlertsByClaim(claimId);
    }

    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }
}
