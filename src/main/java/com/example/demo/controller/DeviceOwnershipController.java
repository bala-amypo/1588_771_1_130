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
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord record) {
        return service.registerDevice(record);
    }

    @GetMapping("/{serial}")
    public Optional<DeviceOwnershipRecord> getDevice(@PathVariable String serial) {
        return service.getBySerial(serial);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }

    @PatchMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(@PathVariable Long id, @RequestParam Boolean active) {
        return service.updateDeviceStatus(id, active);
    }
}
