package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    /**
     * Create a new fraud rule
     * POST /rules
     */
    @PostMapping
    public FraudRule createRule(
            @RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    /**
     * Get all active fraud rules
     * GET /rules/active
     */
    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }
}
