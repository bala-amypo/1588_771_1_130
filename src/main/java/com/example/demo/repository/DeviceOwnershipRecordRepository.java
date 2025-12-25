package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing DeviceOwnershipRecord entities.
 * Extends JpaRepository to provide CRUD operations and query methods.
 */
@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

    /**
     * Example custom query method to find a device ownership record by its serial number.
     * Spring Data JPA will automatically implement this method based on the method name.
     *
     * @param serialNumber the serial number of the device
     * @return an Optional containing the DeviceOwnershipRecord if found, or empty if not
     */
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);

    // You can add more custom query methods if needed, e.g.,
    // List<DeviceOwnershipRecord> findByOwnerName(String ownerName);
}
