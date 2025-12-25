package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport reportStolenDevice(StolenDeviceReport report);

    List<StolenDeviceReport> getAllStolenDevices();

    StolenDeviceReport getStolenDeviceById(Long id);

    void deleteStolenDevice(Long id);
}
