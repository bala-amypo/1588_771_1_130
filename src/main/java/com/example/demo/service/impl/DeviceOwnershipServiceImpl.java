package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public DeviceOwnershipRecord getBySerial(String serial) {
        return repository.findBySerial(serial)
                .orElseThrow(() ->
                        new RuntimeException("Device not found with serial: " + serial));
    }

    @Override
    public List<DeviceOwnershipRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, Boolean active) {
        DeviceOwnershipRecord device = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Device not found with id: " + id));

        device.setActive(active);
        return repository.save(device);
    }
}
