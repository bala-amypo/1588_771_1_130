// 5️⃣ Controller
package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@RequiredArgsConstructor
public class FraudAlertController {

    private final FraudAlertService service;

    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.saveAlert(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }

    @GetMapping("/resolved")
    public List<FraudAlertRecord> getResolvedAlerts(@RequestParam boolean resolved) {
        return service.getResolvedAlerts(resolved);
    }

    @PutMapping("/{id}/status")
    public FraudAlertRecord updateStatus(@PathVariable Long id, @RequestParam boolean resolved) {
        return service.updateAlertStatus(id, resolved);
    }
}
