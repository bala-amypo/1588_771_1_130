package com.example.demo.repository;

import com.example.demo.model.StolenDeviceReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport, Long> {

    // Find reports by serial number
    List<StolenDeviceReport> findBySerialNumber(String serialNumber);

    // Check if a report exists for a given serial number
    boolean existsBySerialNumber(String serialNumber);
}
