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

    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolveAlert(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getAlertsBySerial(serialNumber);
    }

    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getByClaim(@PathVariable Long claimId) {
        return service.getAlertsByClaim(claimId);
    }

    @GetMapping
    public List<FraudAlertRecord> getAll() {
        return service.getAllAlerts();
    }
}
