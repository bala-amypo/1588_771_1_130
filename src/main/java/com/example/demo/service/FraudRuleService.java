package com.example.demo.service;

import com.example.demo.model.FraudRule;

import java.util.List;
import java.util.Optional;

public interface FraudRuleService {

    FraudRule createRule(FraudRule rule);

    FraudRule updateRule(Long id, FraudRule updatedRule);

    Optional<FraudRule> getById(Long id);

    List<FraudRule> getActiveRules();

    Optional<FraudRule> getRuleByCode(String ruleCode);

    List<FraudRule> getAllRules();
}
