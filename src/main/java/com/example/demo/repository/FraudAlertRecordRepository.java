package com.example.demo.repository;
import com.example.demo.model.FraudAlertRecord;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface FraudAlertRecordRepository {
    Optional<FraudAlertRecord> findById(Long id);
    List<FraudAlertRecord> findByClaimId(Long claimId);
    FraudAlertRecord save(FraudAlertRecord alert);
}
