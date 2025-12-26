package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    @Override
    public FraudRule createRule(FraudRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}
