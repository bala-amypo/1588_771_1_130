package com.example.demo.service.impl;

import com.example.demo.model.FraudRuleRecord;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRuleRecord saveRule(FraudRuleRecord rule) {
        return repository.save(rule);
    }

    @Override
    public List<FraudRuleRecord> getAllRules() {
        return repository.findAll();
    }

    @Override
    public FraudRuleRecord updateRuleStatus(Long id, boolean active) {
        FraudRuleRecord rule = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        rule.setActive(active);
        return repository.save(rule);
    }
}
