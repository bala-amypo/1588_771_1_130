package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    // ✅ REQUIRED constructor for tests
    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    // -------- Optional endpoints --------

    @PostMapping
    public StolenDeviceReport reportDevice(
            @RequestBody StolenDeviceReport report) {
        return service.reportDevice(report);
    }

    @GetMapping("/{id}")
    public Optional<StolenDeviceReport> getReportById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }

    @PutMapping("/{id}/status")
    public StolenDeviceReport updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
