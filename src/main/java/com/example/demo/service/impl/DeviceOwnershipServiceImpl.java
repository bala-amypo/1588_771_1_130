package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        if (repo.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number already exists");
        }
        return repo.save(device);
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serial) {
        return repo.findBySerialNumber(serial)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecord> getAll() {
        return repo.findAll();
    }
    
}
