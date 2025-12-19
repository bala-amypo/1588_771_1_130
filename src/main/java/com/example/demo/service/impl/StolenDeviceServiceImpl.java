package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public StolenDeviceReport report(StolenDeviceReport report) {
        return repository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getBySerial(String serial) {
        return repository.findBySerialNumber(serial);
    }

    @Override
    public StolenDeviceReport getReportById(Long id) {
        Optional<StolenDeviceReport> report = repository.findById(id);
        return report.orElse(null); // or throw custom exception if preferred
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repository.findAll();
    }
}
