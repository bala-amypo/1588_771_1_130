package com.example.demo.repository;
import com.example.demo.model.FraudRule;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRuleRepository {
    Optional<FraudRule> findByRuleCode(String ruleCode);
    List<FraudRule> findByActiveTrue();
    FraudRule save(FraudRule rule);
}
