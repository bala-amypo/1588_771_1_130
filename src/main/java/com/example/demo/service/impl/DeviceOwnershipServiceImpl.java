package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRepository repo;

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        return repo.save(record);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public DeviceOwnershipRecord getDeviceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteDevice(Long id) {
        repo.deleteById(id);
    }
}
