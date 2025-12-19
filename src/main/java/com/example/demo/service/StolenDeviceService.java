package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport reportStolen(StolenDeviceReport report);

    StolenDeviceReport getById(Long id);

    List<StolenDeviceReport> getBySerial(String serial);

    List<StolenDeviceReport> getAll();
}
