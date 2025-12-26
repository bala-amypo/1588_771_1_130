package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord, Long> {

    // This works because entity has "deviceId"
    List<FraudAlertRecord> findByDeviceId(String deviceId);
}
