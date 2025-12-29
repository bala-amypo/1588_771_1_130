package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
@Tag(name = "Fraud Rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    // Create fraud rule
    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    // Update fraud rule
    @PutMapping("/{id}")
    public FraudRule updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    // Get active rules
    @GetMapping("/active")
    public List<FraudRule> getActive() {
        return service.getActiveRules();
    }

    // Get rule by ID
    @GetMapping("/{id}")
    public ResponseEntity<FraudRule> getById(@PathVariable Long id) {
        return service.getRuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all rules
    @GetMapping
    public List<FraudRule> getAll() {
        return service.getAllRules();
    }
}
