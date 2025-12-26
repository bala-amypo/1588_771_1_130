package com.example.demo.repository; // MUST match the folder

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceOwnershipRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
