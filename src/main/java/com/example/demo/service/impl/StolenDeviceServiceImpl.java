package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepo) {
        this.stolenRepo = stolenRepo;
    }

    @Override
    public StolenDeviceReport reportDevice(StolenDeviceReport report) {
        if (stolenRepo.existsBySerialNumber(report.getSerialNumber())) {
            throw new IllegalArgumentException("Device already reported as stolen");
        }
        return stolenRepo.save(report);
    }

    @Override
    public Optional<StolenDeviceReport> getBySerial(String serialNumber) {
        return stolenRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepo.findAll();
    }

    @Override
    public void removeReport(Long id) {
        if (!stolenRepo.existsById(id)) {
            throw new NoSuchElementException("Report not found");
        }
        stolenRepo.deleteById(id);
    }
}
