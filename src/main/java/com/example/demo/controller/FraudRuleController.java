package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
