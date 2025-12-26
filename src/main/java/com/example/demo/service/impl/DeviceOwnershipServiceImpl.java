package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repo.save(device);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public Optional<DeviceOwnershipRecord> getDeviceBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }
}
