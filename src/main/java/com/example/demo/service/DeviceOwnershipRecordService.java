package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipService(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        repository.findBySerialNumber(device.getSerialNumber())
                .ifPresent(d -> {
                    throw new RuntimeException("Serial number already exists");
                });
        return repository.save(device);
    }

    public DeviceOwnershipRecord getBySerial(String serial) {
        return repository.findBySerialNumber(serial)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public DeviceOwnershipRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    public DeviceOwnershipRecord updateStatus(Long id, boolean active) {
        DeviceOwner
