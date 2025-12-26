package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.*;

public interface DeviceOwnershipService {
    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord d);
    Optional<DeviceOwnershipRecord> getBySerial(String serial);
    List<DeviceOwnershipRecord> getAllDevices();
    DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active);
}
