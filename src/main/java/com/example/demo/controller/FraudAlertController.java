package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fraud-alerts")
@Tag(name = "Fraud Alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }


    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolve(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

   
    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getByClaim(
            @PathVariable Long claimId) {
        return service.getAlertsByClaim(claimId);
    }


    @GetMapping("/{id}")
    public Optional<FraudAlertRecord> getById(@PathVariable Long id) {
        return service.getAlertsByClaim(id)
                .stream()
                .filter(a -> id.equals(a.getId()))
                .findFirst();
    }


    @GetMapping
    public List<FraudAlertRecord> getAll() {
        return service.getAlertsByClaim(0L);
    }
}
