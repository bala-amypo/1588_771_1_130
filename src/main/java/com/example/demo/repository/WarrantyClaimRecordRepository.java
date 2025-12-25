package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.example.demo.model.*;

public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecord, Long> {

    boolean existsBySerialNumberAndClaimReason(String s, String r);
    List<WarrantyClaimRecord> findBySerialNumber(String s);
}
