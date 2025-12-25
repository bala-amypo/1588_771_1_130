package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repo;

    @Override
    public StolenDeviceReport reportStolenDevice(StolenDeviceReport report) {
        return repo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllStolenDevices() {
        return repo.findAll();
    }

    @Override
    public StolenDeviceReport getStolenDeviceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteStolenDevice(Long id) {
        repo.deleteById(id);
    }
}
