package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

    // Find a device by serial number
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);

    // Check if a device with the given serial number already exists
    boolean existsBySerialNumber(String serialNumber);
}
