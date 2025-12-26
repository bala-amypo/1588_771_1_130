package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.saveAlert(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }

    @GetMapping("/resolved/{status}")
    public List<FraudAlertRecord> getResolvedAlerts(@PathVariable boolean status) {
        return service.getResolvedAlerts(status);
    }

    @PutMapping("/{id}")
    public FraudAlertRecord updateAlertStatus(
            @PathVariable Long id,
            @RequestParam boolean resolved) {
        return service.updateAlertStatus(id, resolved);
    }
}
