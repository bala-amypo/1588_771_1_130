package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipRecordService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipRecordController {

    @Autowired
    private DeviceOwnershipService service;

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAllDevices();
    }
}
