package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        repository.findByRuleCode(rule.getRuleCode()).ifPresent(r -> {
            throw new IllegalArgumentException("Rule already exists");
        });
        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule rule) {
        FraudRule existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found"));
        existing.setRuleType(rule.getRuleType());
        existing.setDescription(rule.getDescription());
        existing.setActive(rule.getActive());
        return repository.save(existing);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}
