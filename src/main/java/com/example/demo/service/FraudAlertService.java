package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord saveAlert(FraudAlertRecord alert);

    List<FraudAlertRecord> getResolvedAlerts(boolean resolved);

    void updateAlertStatus(Long id, boolean resolved);

    // ADD THIS
    List<FraudAlertRecord> getAllAlerts();
}
