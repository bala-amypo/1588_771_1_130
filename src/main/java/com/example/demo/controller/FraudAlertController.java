package com.example.demo.controller;

import com.example.demo.model.FraudAlert;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    // ✅ REQUIRED constructor for tests
    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    // -------- Optional endpoints --------

    @PostMapping
    public FraudAlert createAlert(@RequestBody FraudAlert alert) {
        return service.createAlert(alert);
    }

    @GetMapping("/{id}")
    public Optional<FraudAlert> getAlertById(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @GetMapping
    public List<FraudAlert> getAllAlerts() {
        return service.getAllAlerts();
    }

    @PutMapping("/{id}/status")
    public FraudAlert updateAlertStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateAlertStatus(id, status);
    }
}
