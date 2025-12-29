package com.example.demo.service;

import com.example.demo.dto.DeviceOwnershipRequest;
import com.example.demo.dto.DeviceOwnershipResponse;
import java.util.List;

public interface DeviceOwnershipService {
    DeviceOwnershipResponse createDeviceOwnership(DeviceOwnershipRequest request);
    List<DeviceOwnershipResponse> getAllDeviceOwnerships();
    DeviceOwnershipResponse getDeviceOwnershipById(Long id);
    DeviceOwnershipResponse updateDeviceOwnership(Long id, DeviceOwnershipRequest request);
    void deleteDeviceOwnership(Long id);
}
