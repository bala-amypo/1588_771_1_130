package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "Stolen Devices")
@SecurityRequirement(name="bearerAuth")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    // Report a stolen device
    @PostMapping
    public StolenDeviceReport reportStolen(
            @RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    // Get stolen reports by serial number
    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(
            @PathVariable String serialNumber) {
        return service.getReportsBySerial(serialNumber);
    }

    // Get stolen report by ID
    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReport> getById(
            @PathVariable Long id) {

        return service.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all stolen reports
    @GetMapping
    public List<StolenDeviceReport> getAll() {
        return service.getAllReports();
    }
}
