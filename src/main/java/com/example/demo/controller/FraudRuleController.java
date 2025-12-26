package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
@RequiredArgsConstructor
public class FraudRuleController {

    private final FraudRuleService service;

    @PostMapping("/create")
    public FraudRule create(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/all")
    public List<FraudRule> getAll() {
        return service.getAllRules();
    }
}
