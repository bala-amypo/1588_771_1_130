package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;
import java.util.List;
import java.util.Optional;

public interface StolenDeviceService {
    StolenDeviceReport reportDevice(StolenDeviceReport report);
    Optional<StolenDeviceReport> getBySerial(String serialNumber);
    List<StolenDeviceReport> getAllReports();
    void removeReport(Long id);
}
