package com.example.demo.repository;

import com.example.demo.model.StolenDeviceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport, Long> {

    // Find a stolen device report by its serial number
    Optional<StolenDeviceReport> findBySerialNumber(String serialNumber);

    // Find all reports filed by a specific user/email
    List<StolenDeviceReport> findByReporterEmail(String reporterEmail);

    // Check if a stolen device report exists for a given serial number
    boolean existsBySerialNumber(String serialNumber);
}
