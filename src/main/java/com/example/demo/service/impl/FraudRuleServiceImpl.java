package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

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
        return repo.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updated) {
        FraudRule r = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found"));
        r.setRuleType(updated.getRuleType());
        r.setDescription(updated.getDescription());
        r.setActive(updated.isActive());
        return repo.save(r);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<FraudRule> getRuleByCode(String code) {
        return repo.findByRuleCode(code);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
