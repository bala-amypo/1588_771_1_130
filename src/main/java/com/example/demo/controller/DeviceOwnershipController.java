package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.impl.DeviceOwnershipServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipServiceImpl service;

    public DeviceOwnershipController(DeviceOwnershipServiceImpl service) {
        this.service = service;
    }

    // Create a new device ownership record
    @PostMapping
    public ResponseEntity<AuthResponse> createDeviceOwnership(
            @RequestBody AuthRequest request) {
        DeviceOwnershipResponse response = service.createDeviceOwnership(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get all device ownership records
    @GetMapping
    public ResponseEntity<List<AuthResponse>> getAllDeviceOwnerships() {
        List<AuthResponse> responseList = service.getAllDeviceOwnerships();
        return ResponseEntity.ok(responseList);
    }

    // Get a device ownership record by ID
    @GetMapping("/{id}")
    public ResponseEntity<AuthResponse> getDeviceOwnershipById(@PathVariable Long id) {
        AuthResponse response = service.getDeviceOwnershipById(id);
        return ResponseEntity.ok(response);
    }

    // Update a device ownership record
    @PutMapping("/{id}")
    public ResponseEntity<AuthResponse> updateDeviceOwnership(
            @PathVariable Long id,
            @RequestBody AuthRequest request) {
        AuthResponse response = service.updateDeviceOwnership(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete a device ownership record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeviceOwnership(@PathVariable Long id) {
        service.deleteDeviceOwnership(id);
        return ResponseEntity.noContent().build();
    }
}
