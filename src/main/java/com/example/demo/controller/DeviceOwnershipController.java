package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    @PostMapping("/register")
    public DeviceOwnershipRecord registerDevice(@RequestBody DeviceOwnershipRecord record) {
        return service.registerDevice(record);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }
}
