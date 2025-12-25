package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    /**
     * Report a stolen device
     * POST /stolen
     */
    @PostMapping
    public StolenDeviceReport reportStolen(
            @RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    /**
     * Get all stolen device reports
     * GET /stolen
     */
    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }
}
