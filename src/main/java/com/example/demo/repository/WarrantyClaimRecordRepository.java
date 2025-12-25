package com.example.demo.repository;

import com.example.demo.model.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarrantyClaimRepository extends JpaRepository<WarrantyClaimRecord, Long> {

    // Find a warranty claim by its serial number
    Optional<WarrantyClaimRecord> findBySerialNumber(String serialNumber);

    // Find all warranty claims by a specific user/email
    List<WarrantyClaimRecord> findByUserEmail(String userEmail);

    // Check if a warranty claim already exists for a device serial number
    boolean existsBySerialNumber(String serialNumber);

    // Find all claims with a specific status (e.g., "Pending", "Approved")
    List<WarrantyClaimRecord> findByStatus(String status);
}
