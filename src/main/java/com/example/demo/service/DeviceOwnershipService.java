package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.Optional;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);

    Optional<DeviceOwnershipRecord> getBySerial(String serialNumber);

    DeviceOwnershipRecord updateDeviceStatus(Long id, Boolean status);

    // Add other methods if needed
}
