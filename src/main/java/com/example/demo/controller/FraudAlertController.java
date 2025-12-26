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

    @PostMapping("/create")
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }
}
