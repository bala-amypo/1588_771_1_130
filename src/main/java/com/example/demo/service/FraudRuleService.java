package com.example.demo.service;

import com.example.demo.model.FraudRule;
import java.util.*;

public interface FraudRuleService {
    FraudRule createRule(FraudRule r);
    List<FraudRule> getActiveRules();
    Optional<FraudRule> getRuleByCode(String code);
}
