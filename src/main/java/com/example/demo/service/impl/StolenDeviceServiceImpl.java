package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceRecordRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceRecordRepository repo;

    public StolenDeviceServiceImpl(StolenDeviceRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return repo.save(report);
    }

    @Override
    public StolenDeviceReport getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    @Override
    public List<StolenDeviceReport> getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    @Override
    public List<StolenDeviceReport> getAll() {
        return repo.findAll();
    }
}
