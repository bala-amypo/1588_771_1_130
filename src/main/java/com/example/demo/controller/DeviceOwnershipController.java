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

    @PostMapping("/register")
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    @GetMapping("/all")
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/{serial}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serial) {
        return service.getBySerial(serial)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @PutMapping("/update/{id}")
    public DeviceOwnershipRecord updateStatus(@PathVariable Long id, @RequestParam Boolean status) {
        return service.updateDeviceStatus(id, status);
    }
}
