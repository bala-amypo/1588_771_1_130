package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord create(DeviceOwnershipRecord record);

    List<DeviceOwnershipRecord> getAll();
}
