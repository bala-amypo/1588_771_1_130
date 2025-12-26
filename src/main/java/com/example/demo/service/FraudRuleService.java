package com.example.demo.service;

import com.example.demo.model.FraudRuleRecord;

import java.util.List;

public interface FraudRuleService {

    FraudRuleRecord saveRule(FraudRuleRecord rule);

    List<FraudRuleRecord> getAllRules();

    FraudRuleRecord updateRuleStatus(Long id, boolean active);
}
