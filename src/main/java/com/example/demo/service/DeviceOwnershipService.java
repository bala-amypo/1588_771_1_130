package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;
import java.util.Optional;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord getById(Long id);

    Optional<DeviceOwnershipRecord> getBySerial(String serialNumber);

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);

    List<DeviceOwnershipRecord> getAllDevices();

    DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active);
}
