package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repo.save(device);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }
}
