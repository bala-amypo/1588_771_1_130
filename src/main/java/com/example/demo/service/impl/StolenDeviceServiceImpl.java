package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.StolenDeviceService;
import java.util.*;

public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository s,
            DeviceOwnershipRecordRepository d) {
        this.stolenRepo = s;
        this.deviceRepo = d;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport r) {
        deviceRepo.findBySerialNumber(r.getSerialNumber()).orElseThrow();
        return stolenRepo.save(r);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepo.findAll();
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return stolenRepo.findBySerialNumber(serial);
    }
}
