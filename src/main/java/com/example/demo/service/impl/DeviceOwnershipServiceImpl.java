package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord d) {
        if (repo.existsBySerialNumber(d.getSerialNumber())) {
            throw new IllegalArgumentException("Device already registered");
        }
        return repo.save(d);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String s) {
        return repo.findBySerialNumber(s);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
        d.setActive(active);
        return repo.save(d);
    }
}
