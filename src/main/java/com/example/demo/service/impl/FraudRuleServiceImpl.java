package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    /**
     * Create a fraud rule.
     * Duplicate ruleCode is not allowed.
     */
    @Override
    public FraudRule createRule(FraudRule rule) {

        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Fraud rule already exists");
        }

        return repo.save(rule);
    }

    /**
     * Get all active rules
     */
    @Override
    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    /**
     * Get rule by code
     */
    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return repo.findByRuleCode(ruleCode);
    }
}
