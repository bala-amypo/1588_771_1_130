package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord d) {
        if (repo.existsBySerialNumber(d.getSerialNumber()))
            throw new IllegalArgumentException();
        return repo.save(d);
    }

    public Optional<DeviceOwnershipRecord> getBySerial(String s) {
        return repo.findBySerialNumber(s);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        d.setActive(active);
        return repo.save(d);
    }
}
