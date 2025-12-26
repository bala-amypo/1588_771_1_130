package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    // ✅ REQUIRED constructor for tests
    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    // -------- Optional endpoints --------

    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/{id}")
    public Optional<FraudRule> getRuleById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }

    @PutMapping("/{id}/status")
    public FraudRule updateRuleStatus(
            @PathVariable Long id,
            @RequestParam boolean enabled) {
        return service.updateRuleStatus(id, enabled);
    }
}
