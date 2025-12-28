package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fraud-rules")
@Tag(name = "Fraud Rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    
    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public FraudRule updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule rule) {
        rule.setId(id);
        return service.createRule(rule);
    }
    @GetMapping("/active")
    public List<FraudRule> getActive() {
        return service.getActiveRules();
    }

    
    @GetMapping("/{id}")
    public Optional<FraudRule> getById(@PathVariable Long id) {
        return service.getActiveRules()
                .stream()
                .filter(r -> id.equals(r.getId()))
                .findFirst();
    }

    @GetMapping
    public List<FraudRule> getAll() {
        return service.getActiveRules();
    }
}
