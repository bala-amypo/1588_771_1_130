package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    @GetMapping("/{serialNumber}")
    public Optional<DeviceOwnershipRecord> getDevice(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    @GetMapping("/all")
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }

    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateDeviceStatus(id, active);
    }
}
