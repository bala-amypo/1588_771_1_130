package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;
import java.util.Optional;

public interface FraudAlertService {

    FraudAlertRecord create(FraudAlertRecord alert);

    FraudAlertRecord resolve(Long id);

    Optional<FraudAlertRecord> getById(Long id);

    List<FraudAlertRecord> getBySerialNumber(String serialNumber);

    List<FraudAlertRecord> getAll();
}
