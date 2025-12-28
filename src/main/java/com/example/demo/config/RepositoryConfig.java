package com.example.demo.config;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class RepositoryConfig {


    @Bean
    public DeviceOwnershipRecordRepository deviceOwnershipRecordRepository() {
        return new DeviceOwnershipRecordRepository() {

            @Override
            public boolean existsBySerialNumber(String serialNumber) {
                return false;
            }

            @Override
            public Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber) {
                return Optional.empty();
            }

            @Override
            public Optional<DeviceOwnershipRecord> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public List<DeviceOwnershipRecord> findAll() {
                return List.of();
            }

            @Override
            public DeviceOwnershipRecord save(DeviceOwnershipRecord record) {
                return record;
            }
        };
    }

    @Bean
    public WarrantyClaimRecordRepository warrantyClaimRecordRepository() {
        return new WarrantyClaimRecordRepository() {

            @Override
            public boolean existsBySerialNumberAndClaimReason(String serial, String reason) {
                return false;
            }

            @Override
            public Optional<WarrantyClaimRecord> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public List<WarrantyClaimRecord> findBySerialNumber(String serial) {
                return List.of();
            }

            @Override
            public List<WarrantyClaimRecord> findAll() {
                return List.of();
            }

            @Override
            public WarrantyClaimRecord save(WarrantyClaimRecord record) {
                return record;
            }
        };
    }

    
    @Bean
    public StolenDeviceReportRepository stolenDeviceReportRepository() {
        return new StolenDeviceReportRepository() {

            @Override
            public boolean existsBySerialNumber(String serial) {
                return false;
            }

            @Override
            public Optional<StolenDeviceReport> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public List<StolenDeviceReport> findBySerialNumber(String serial) {
                return List.of();
            }

            @Override
            public List<StolenDeviceReport> findAll() {
                return List.of();
            }

            @Override
            public StolenDeviceReport save(StolenDeviceReport report) {
                return report;
            }
        };
    }
      @Bean
    public UserRepository userRepository() {

        return new UserRepository() {

            @Override
            public Optional<User> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public User save(User user) {
                return user;
            }
        };
    }

    @Bean
    public FraudRuleRepository fraudRuleRepository() {
        return new FraudRuleRepository() {

            @Override
            public Optional<FraudRule> findByRuleCode(String ruleCode) {
                return Optional.empty();
            }

            @Override
            public List<FraudRule> findByActiveTrue() {
                return List.of();
            }

            @Override
            public FraudRule save(FraudRule rule) {
                return rule;
            }
        };
    }

 
    @Bean
    public FraudAlertRecordRepository fraudAlertRecordRepository() {
        return new FraudAlertRecordRepository() {

            @Override
            public Optional<FraudAlertRecord> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public List<FraudAlertRecord> findByClaimId(Long claimId) {
                return List.of();
            }

            @Override
            public FraudAlertRecord save(FraudAlertRecord alert) {
                return alert;
            }
        };
    }
}
