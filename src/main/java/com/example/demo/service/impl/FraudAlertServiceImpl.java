package com.example.demo.service.impl;

import com.example.demo.model.FraudAlert;
import com.example.demo.repository.FraudAlertRepository;
import com.example.demo.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository repository;

    @Override
    public FraudAlert createAlert(FraudAlert alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlert> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public List<FraudAlert> getAlertsBySerial(String serial) {
        return repository.findBySerialNumber(serial);
    }
}
