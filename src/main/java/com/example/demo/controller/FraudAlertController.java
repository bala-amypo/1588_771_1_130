package com.example.demo.controller;

import com.example.demo.model.FraudAlert;
import com.example.demo.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@RequiredArgsConstructor
public class FraudAlertController {

    private final FraudAlertService service;

    @PostMapping("/create")
    public FraudAlert create(@RequestBody FraudAlert alert) {
        return service.createAlert(alert);
    }

    @GetMapping("/all")
    public List<FraudAlert> getAll() {
        return service.getAllAlerts();
    }

    @GetMapping("/serial/{serial}")
    public List<FraudAlert> getBySerial(@PathVariable String serial) {
        return service.getAlertsBySerial(serial);
    }
}
