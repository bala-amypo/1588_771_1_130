package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceOwnershipRecord create(@RequestBody DeviceOwnershipRecord record) {
        return service.create(record);  
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAll();        
    }
}
