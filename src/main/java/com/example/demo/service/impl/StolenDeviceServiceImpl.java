package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository repo,
            DeviceOwnershipRecordRepository deviceRepo) {

        this.repo = repo;
        this.deviceRepo = deviceRepo;
    }

    /**
     * Report a stolen device.
     * Throws NoSuchElementException if device does not exist.
     */
    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {

        deviceRepo.findBySerialNumber(report.getSerialNumber())
                .orElseThrow(NoSuchElementException::new);

        return repo.save(report);
    }

    /**
     * Get all stolen device reports
     */
    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }

    /**
     * Get stolen reports by serial number
     */
    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }
}
