package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecordRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DeviceOwnershipRecordService {

    @Autowired
    private DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repo.save(device);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }
}
