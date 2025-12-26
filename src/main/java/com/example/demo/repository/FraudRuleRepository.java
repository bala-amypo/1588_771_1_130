package com.example.demo.repository;

import com.example.demo.model.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {
    // Optional: add custom queries if needed, e.g.,
    // List<FraudRule> findByRuleName(String ruleName);
}
