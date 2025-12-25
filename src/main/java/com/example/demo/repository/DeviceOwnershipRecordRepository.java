package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceOwnershipRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

    // Find a device by its serial number
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);

    // Find all devices owned by a specific user
    List<DeviceOwnershipRecord> findByOwnerEmail(String ownerEmail);

    // Check if a device exists by serial number
    boolean existsBySerialNumber(String serialNumber);
}
