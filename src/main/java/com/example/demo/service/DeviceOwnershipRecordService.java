package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipRecordService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipRecordService(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    public DeviceOwnershipRecord create(DeviceOwnershipRecord record) {
        return repository.save(record);
    }

    public DeviceOwnershipRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
    }

    public List<DeviceOwnershipRecord> getAll() {
        return repository.findAll();
    }

    public DeviceOwnershipRecord deactivate(Long id) {
        DeviceOwnershipRecord record = getById(id);
        record.setActive(false);
        return repository.save(record);
    }
}
