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

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping("/report")
    public StolenDeviceReport reportStolen(@RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    @GetMapping("/{id}")
    public Optional<StolenDeviceReport> getReportById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getReportsBySerial(@PathVariable String serialNumber) {
        return service.getReportsBySerial(serialNumber);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }
}
