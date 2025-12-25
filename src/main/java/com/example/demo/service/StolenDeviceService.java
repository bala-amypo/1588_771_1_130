package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    /**
     * Report a device as stolen
     */
    StolenDeviceReport reportStolen(StolenDeviceReport report);

    /**
     * Get all stolen device reports
     */
    List<StolenDeviceReport> getAllReports();

    /**
     * Get stolen device reports by serial number
     */
    List<StolenDeviceReport> getReportsBySerial(String serialNumber);
}
