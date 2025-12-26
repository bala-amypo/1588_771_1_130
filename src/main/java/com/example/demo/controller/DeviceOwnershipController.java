package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    @PostMapping("/register")
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord record) {
        return service.registerDevice(record);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAllDevices();
    }

    @GetMapping("/{serial}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serial) {
        return service.getDeviceBySerial(serial);
    }
}
