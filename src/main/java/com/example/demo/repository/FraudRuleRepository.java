package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.example.demo.model.*;

public interface FraudRuleRepository
        extends JpaRepository<FraudRule, Long> {

    Optional<FraudRule> findByRuleCode(String code);
    List<FraudRule> findByActiveTrue();
}
