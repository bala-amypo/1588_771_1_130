package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;
import java.util.Optional;

public interface StolenDeviceService {

    StolenDeviceReport report(StolenDeviceReport report);

    Optional<StolenDeviceReport> getById(Long id);

    List<StolenDeviceReport> getBySerialNumber(String serialNumber);

    List<StolenDeviceReport> getAll();
}
