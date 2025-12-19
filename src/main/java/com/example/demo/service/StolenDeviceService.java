package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport report(StolenDeviceReport report);

    List<StolenDeviceReport> getBySerial(String serial);

    StolenDeviceReport getReportById(Long id);

    List<StolenDeviceReport> getAllReports();
}
