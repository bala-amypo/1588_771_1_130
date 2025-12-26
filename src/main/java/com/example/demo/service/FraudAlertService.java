package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord saveAlert(FraudAlertRecord alert);

    List<FraudAlertRecord> getAllAlerts();

    List<FraudAlertRecord> getResolvedAlerts(boolean resolved);

    FraudAlertRecord updateAlertStatus(Long id, boolean resolved);
}
