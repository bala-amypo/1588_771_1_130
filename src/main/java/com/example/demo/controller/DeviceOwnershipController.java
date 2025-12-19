package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    // Register a new device (checks for duplicate serial number)
    @PostMapping("/register")
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    // Get all devices
    @GetMapping("/all")
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }

    // Get a device by serial number
    @GetMapping("/serial/{serial}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serial) {
        return service.getBySerial(serial)
                .orElseThrow(() -> new IllegalArgumentException("Device not found with serial: " + serial));
    }

    // Update device active status
    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateDeviceStatus(@PathVariable Long id,
                                                    @RequestParam boolean active) {
        return service.updateDeviceStatus(id, active);
    }

    // Get a device by ID
    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
