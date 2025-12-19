package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        Optional<FraudRule> existingRuleOpt = repository.findById(id);
        if (existingRuleOpt.isPresent()) {
            FraudRule existingRule = existingRuleOpt.get();
            existingRule.setRuleCode(updatedRule.getRuleCode());
            existingRule.setDescription(updatedRule.getDescription());
            existingRule.setActive(updatedRule.isActive());
            // Add any other fields you have in FraudRule
            return repository.save(existingRule);
        }
        return null; // or throw custom exception
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public FraudRule getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode).orElse(null);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}
