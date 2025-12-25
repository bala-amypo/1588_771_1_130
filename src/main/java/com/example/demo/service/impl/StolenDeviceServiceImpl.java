package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.StolenDeviceService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository repo, DeviceOwnershipRecordRepository deviceRepo) {
        this.repo = repo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        DeviceOwnershipRecord device = deviceRepo.findBySerialNumber(report.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
        return repo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }
}
