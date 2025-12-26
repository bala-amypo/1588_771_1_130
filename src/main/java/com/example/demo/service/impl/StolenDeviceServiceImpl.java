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

    private final StolenDeviceReportRepository repository;

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return repository.save(report);
    }

    @Override
    public StolenDeviceReport getReportById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return repository.findBySerialNumber(serial);
    }
}
