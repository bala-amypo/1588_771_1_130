package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {

    /**
     * Create a new fraud alert
     */
    FraudAlertRecord createAlert(FraudAlertRecord alert);

    /**
     * Resolve an existing fraud alert
     */
    FraudAlertRecord resolveAlert(Long alertId);

    /**
     * Get alerts by claim ID
     */
    List<FraudAlertRecord> getAlertsByClaim(Long claimId);
}
