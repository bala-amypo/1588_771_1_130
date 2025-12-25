package com.example.demo.repository;

import com.example.demo.model.StolenDeviceReport;
import java.util.List;
import java.util.Optional;

public interface StolenDeviceReportRepository {
    StolenDeviceReport save(StolenDeviceReport report);
    Optional<StolenDeviceReport> findById(Long id);
    boolean existsBySerialNumber(String serial);
    List<StolenDeviceReport> findBySerialNumber(String serial);
    List<StolenDeviceReport> findAll();
}
