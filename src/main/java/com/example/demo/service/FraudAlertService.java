package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {
    FraudAlertRecord create(FraudAlertRecord alert);
    List<FraudAlertRecord> getBySerial(String serial);
}
