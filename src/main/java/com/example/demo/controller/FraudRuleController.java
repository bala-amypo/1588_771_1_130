package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fraud/rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}/update")
    public FraudRule updateRule(@PathVariable Long id, @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{ruleCode}")
    public Optional<FraudRule> getRule(@PathVariable String ruleCode) {
        return service.getRuleByCode(ruleCode);
    }

    @GetMapping("/all")
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
