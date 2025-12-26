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
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord record) {
        return service.registerDevice(record);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/{serialNumber}")
    public DeviceOwnershipRecord getDevice(@PathVariable String serialNumber) {
        return service.getDeviceBySerial(serialNumber);
    }
}
