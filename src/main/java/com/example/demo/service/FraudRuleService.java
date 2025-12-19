package com.example.demo.service;

import com.example.demo.model.FraudRule;

import java.util.List;

public interface FraudRuleService {
    FraudRule create(FraudRule rule);
    List<FraudRule> getActive();
}
