package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService s) {
        this.service = s;
    }

    @PostMapping
    public DeviceOwnershipRecord register(
            @RequestBody DeviceOwnershipRecord d) {
        return service.registerDevice(d);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> all() {
        return service.getAllDevices();
    }
}
