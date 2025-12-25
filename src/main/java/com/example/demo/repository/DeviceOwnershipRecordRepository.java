package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.example.demo.model.*;

public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecord, Long> {

    boolean existsBySerialNumber(String serialNumber);
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
