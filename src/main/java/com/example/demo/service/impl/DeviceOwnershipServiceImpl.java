package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRepository repository;

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
}
