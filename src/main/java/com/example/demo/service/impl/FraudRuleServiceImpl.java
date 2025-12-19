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
    public FraudRule create(FraudRule rule) {
        return repository.save(rule);
    }

    @Override
    public FraudRule update(Long id, FraudRule updated) {
        FraudRule rule = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        rule.setRuleCode(updated.getRuleCode());
        rule.setDescription(updated.getDescription());
        rule.setActive(updated.isActive());
        return repository.save(rule);
    }

    @Override
    public Optional<FraudRule> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getAll() {
        return repository.findAll();
    }
}
