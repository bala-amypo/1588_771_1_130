package com.example.demo.service.impl;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import java.util.List;
import java.util.Optional;

public class FraudRuleServiceImpl
        implements FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Duplicate rule");
        }
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
}
