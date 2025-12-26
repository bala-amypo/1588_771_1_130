package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<DeviceOwnershipRecord> registerDevice(@RequestBody DeviceOwnershipRecord device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @GetMapping("/")
    public ResponseEntity<List<DeviceOwnershipRecord>> getAll() {
        return ResponseEntity.ok(service.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceOwnershipRecord> getById(@PathVariable Long id) {
        return service.getBySerial(String.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<DeviceOwnershipRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeviceOwnershipRecord> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateDeviceStatus(id, active));
    }
}
