package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record);

    List<DeviceOwnershipRecord> getAllDevices();

    DeviceOwnershipRecord getDeviceById(Long id);

    void deleteDevice(Long id);
}
