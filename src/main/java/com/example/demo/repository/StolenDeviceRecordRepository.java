package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.example.demo.model.*;

public interface StolenDeviceRecortRepository
        extends JpaRepository<StolenDeviceReport, Long> {

    boolean existsBySerialNumber(String serialNumber);
    List<StolenDeviceReport> findBySerialNumber(String serialNumber);
}
