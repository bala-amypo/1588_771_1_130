package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {
    // Report a stolen device
    StolenDeviceReport report(StolenDeviceReport report);

    // Get reports by serial number
    List<StolenDeviceReport> getBySerial(String serial);

    // Get a report by its ID
    StolenDeviceReport getReportById(Long id);

    // Get all reports
    List<StolenDeviceReport> getAllReports();
}
