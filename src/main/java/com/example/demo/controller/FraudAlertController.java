package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    /**
     * Create a fraud alert
     * POST /alerts
     */
    @PostMapping
    public FraudAlertRecord createAlert(
            @RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    /**
     * Resolve a fraud alert
     * PUT /alerts/{id}/resolve
     */
    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolveAlert(
            @PathVariable Long id) {
        return service.resolveAlert(id);
    }
}
