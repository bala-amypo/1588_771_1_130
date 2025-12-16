package com.example.project.models;

import java.time.LocalDateTime;

public class StolenDeviceReport {
    private long id;
    private String serialNumber;
    private String reportedBy;
    private LocalDateTime reportDate;
    private String details;
    
    public StolenDeviceReport() {}

    public StolenDeviceReport(String serialNumber,String reportedBy,LocalDateTime reportDate,String details) {
        this.serialNumber=serialNumber;
        this.reportedBy=reportedBy;
        this.reportDate=reportDate;
        this.details=details;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public String getDetails() {
        return details;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}
