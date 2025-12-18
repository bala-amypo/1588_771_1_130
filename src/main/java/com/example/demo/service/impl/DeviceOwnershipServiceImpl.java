package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repository;

    @Override
    public DeviceOwnershipRecord create(DeviceOwnershipRecord record) {

        // Duplicate check
        repository.findBySerialNumber(record.getSerialNumber())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException(
                            "Device ownership already exists for serial number: "
                                    + record.getSerialNumber()
                    );
                });

        return repository.save(record);
    }

    @Override
    public List<DeviceOwnershipRecord> getAll() {
        return repository.findAll();
    }
}
