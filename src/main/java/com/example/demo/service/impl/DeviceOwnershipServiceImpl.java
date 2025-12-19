package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serial) {
        return repository.findBySerialNumber(serial);
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        // Check if a device with the same serial already exists
        if (repository.findBySerialNumber(device.getSerialNumber()).isPresent()) {
            throw new IllegalArgumentException("Device with this serial number already exists!");
        }
        return repository.save(device);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        Optional<DeviceOwnershipRecord> optionalDevice = repository.findById(id);
        if (optionalDevice.isPresent()) {
            DeviceOwnershipRecord device = optionalDevice.get();
            device.setActive(active);
            return repository.save(device);
        } else {
            throw new IllegalArgumentException("Device not found with id: " + id);
        }
    }
}
