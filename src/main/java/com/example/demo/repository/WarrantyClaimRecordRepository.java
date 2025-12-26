package com.example.demo.repository;

import com.example.demo.model.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecord, Long> {

    Optional<WarrantyClaimRecord> findByClaimId(String claimId);
}
