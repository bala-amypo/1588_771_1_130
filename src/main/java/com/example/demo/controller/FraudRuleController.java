package com.example.demo.controller;

import com.example.demo.model.FraudRuleRecord;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public FraudRuleRecord createRule(@RequestBody FraudRuleRecord rule) {
        return service.saveRule(rule);
    }

    @GetMapping
    public List<FraudRuleRecord> getAllRules() {
        return service.getAllRules();
    }

    @PutMapping("/{id}")
    public FraudRuleRecord updateRuleStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateRuleStatus(id, active);
    }
}
