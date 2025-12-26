package com.example.demo.repository;

import com.example.demo.model.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudAlertRepository extends JpaRepository<FraudAlert, Long> {
    List<FraudAlert> findBySerialNumber(String serial);
}
