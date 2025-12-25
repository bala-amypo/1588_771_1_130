package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.List;
import java.util.Optional;

public interface DeviceOwnershipRecordRepository {
    DeviceOwnershipRecord save(DeviceOwnershipRecord record);
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
    Optional<DeviceOwnershipRecord> findById(Long id);
    boolean existsBySerialNumber(String serialNumber);
    List<DeviceOwnershipRecord> findAll();
}
