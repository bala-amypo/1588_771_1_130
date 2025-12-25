package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        if (repo.existsBySerialNumber(record.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial number");
        }
        return repo.save(record);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, Boolean active) {
        DeviceOwnershipRecord record = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
        record.setActive(active);
        return repo.save(record);
    }
}
