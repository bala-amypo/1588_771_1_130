package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {

    // Create a new fraud alert
    FraudAlertRecord createAlert(FraudAlertRecord alert);

    // Resolve an existing alert by ID
    FraudAlertRecord resolveAlert(Long id);

    // Get alerts by serial number
    List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

    // Get alerts by claim ID
    List<FraudAlertRecord> getAlertsByClaim(Long claimId);

    // Get all alerts
    List<FraudAlertRecord> getAllAlerts();
}
