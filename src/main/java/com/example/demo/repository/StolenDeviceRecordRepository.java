package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.example.demo.model.*;

public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReport, Long> {

    boolean existsBySerialNumber(String s);
    List<StolenDeviceReport> findBySerialNumber(String s);
}
