package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.*;

public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
    boolean existsBySerialNumber(String serialNumber);
}
