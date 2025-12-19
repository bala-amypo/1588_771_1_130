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

    // Create a new fraud alert
    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return service.create(alert);
    }

    // Get all fraud alerts
    @GetMapping("/all")
    public List<FraudAlertRecord> getAll() {
        return service.getAll();
    }

    // Get a fraud alert by ID
    @GetMapping("/{id}")
    public FraudAlertRecord getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    // Mark a fraud alert as resolved
    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    // Get fraud alert by device serial number
    @GetMapping("/serial/{serial}")
    public FraudAlertRecord getBySerial(@PathVariable String serial) {
        return service.getBySerialNumber(serial).orElse(null);
    }
}
