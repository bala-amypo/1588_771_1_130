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
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return repo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }
}
