package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.Optional;

public interface DeviceOwnershipService {
    DeviceOwnershipRecord getById(Long id);
    Optional<DeviceOwnershipRecord> getBySerial(String serial);
}
