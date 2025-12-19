package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-ownerships")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    @GetMapping("/id/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/serial/{serial}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serial) {
        return service.getBySerial(serial);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateDeviceStatus(id, active);
    }
}
