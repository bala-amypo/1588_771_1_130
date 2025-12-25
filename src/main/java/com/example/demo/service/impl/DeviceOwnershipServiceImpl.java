package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repository.save(device);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, Boolean status) {
        DeviceOwnershipRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        record.setStatus(status);
        return repository.save(record);
    }
}
