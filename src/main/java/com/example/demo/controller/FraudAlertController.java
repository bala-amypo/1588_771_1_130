package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    // Create a new alert
    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    // Resolve an alert by ID
    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolve(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    // Get alerts by serial number
    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> bySerial(@PathVariable String serialNumber) {
        return service.getAlertsBySerial(serialNumber);
    }

    // Get alerts by claim ID
    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> byClaim(@PathVariable Long claimId) {
        return service.getAlertsByClaim(claimId);
    }

    // Get all alerts
    @GetMapping
    public List<FraudAlertRecord> all() {
        return service.getAllAlerts();
    }

    // Get alert by ID
    @GetMapping("/{id}")
    public FraudAlertRecord getById(@PathVariable Long id) {
        return service.getAllAlerts().stream()
                      .filter(alert -> alert.getId().equals(id))
                      .findFirst()
                      .orElse(null); // or throw custom exception
    }
}
