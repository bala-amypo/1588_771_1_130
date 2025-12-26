package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen")
@RequiredArgsConstructor
public class StolenDeviceController {

    private final StolenDeviceService service;

    @PostMapping("/report")
    public StolenDeviceReport report(@RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/serial/{serial}")
    public List<StolenDeviceReport> getBySerial(@PathVariable String serial) {
        return service.getReportsBySerial(serial);
    }
}
