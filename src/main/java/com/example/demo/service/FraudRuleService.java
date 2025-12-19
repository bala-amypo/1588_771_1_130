package com.example.demo.service;

import com.example.demo.model.FraudRule;

import java.util.List;
import java.util.Optional;

public interface FraudRuleService {

    FraudRule create(FraudRule rule);

    FraudRule update(Long id, FraudRule rule);

    Optional<FraudRule> getById(Long id);

    Optional<FraudRule> getRuleByCode(String ruleCode);

    List<FraudRule> getAll();
}
