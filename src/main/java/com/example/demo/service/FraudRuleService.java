package com.example.demo.service;

import com.example.demo.model.FraudRule;

import java.util.List;
import java.util.Optional;

public interface FraudRuleService {

    /**
     * Create a new fraud rule.
     * Throws IllegalArgumentException if ruleCode already exists.
     */
    FraudRule createRule(FraudRule rule);

    /**
     * Get all active fraud rules
     */
    List<FraudRule> getActiveRules();

    /**
     * Get fraud rule by rule code
     */
    Optional<FraudRule> getRuleByCode(String ruleCode);
}
