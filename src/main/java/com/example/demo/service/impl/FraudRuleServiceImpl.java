package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }
        rule.setCreatedAt(LocalDateTime.now());
        if (rule.getActive() == null) rule.setActive(true);
        return repo.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule rule = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
        rule.setDescription(updatedRule.getDescription());
        rule.setRuleType(updatedRule.getRuleType());
        rule.setActive(updatedRule.getActive());
        return repo.save(rule);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return repo.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }

    public Optional<FraudRule> getRuleById(Long id) {
        return repo.findById(id);
    }
}
