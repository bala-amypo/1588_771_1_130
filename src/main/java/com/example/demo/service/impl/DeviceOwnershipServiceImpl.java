package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // <-- important!
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
}
