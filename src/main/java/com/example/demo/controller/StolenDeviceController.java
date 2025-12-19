package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping
    public StolenDeviceReport report(@RequestBody StolenDeviceReport report) {
        return service.report(report);
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @GetMapping("/serial/{serial}")
    public StolenDeviceReport getBySerial(@PathVariable String serial) {
        return service.getBySerialNumber(serial).orElse(null);
    }

    @GetMapping("/all")
    public List<StolenDeviceReport> getAll() {
        return service.getAll();
    }
}
