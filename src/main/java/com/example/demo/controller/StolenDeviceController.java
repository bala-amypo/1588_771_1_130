package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping("/report")
    public StolenDeviceReport reportDevice(@RequestBody StolenDeviceReport report) {
        return service.reportStolenDevice(report);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllStolenDevices();
    }
}
