package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-ownerships")
public class DeviceOwnershipRecordController {

    private final DeviceOwnershipRecordService service;

    public DeviceOwnershipRecordController(DeviceOwnershipRecordService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceOwnershipRecord create(@RequestBody DeviceOwnershipRecord record) {
        return service.create(record);
    }

    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public DeviceOwnershipRecord deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
