package com.example.demo.service;

import java.util.*;
import com.example.demo.model.*;

public interface DeviceOwnershipService {
    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord d);
    Optional<DeviceOwnershipRecord> getBySerial(String s);
    List<DeviceOwnershipRecord> getAllDevices();
    DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active);
}
